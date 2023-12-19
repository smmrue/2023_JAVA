import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MessengerServer {
    private final int serverPort = 5001;
    private List<ClientHandler> clients;
    private DatagramSocket serverSocket;

    public MessengerServer() throws IOException {
        clients = new ArrayList<>();
        serverSocket = new DatagramSocket(serverPort);
    }

    public void start() {
        while (true) {
            try {
                byte[] buf = new byte[256];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                serverSocket.receive(packet);

                // 클라이언트로부터 받은 메시지
                String receivedMessage = new String(buf, 0, packet.getLength());

                // 새로운 클라이언트 핸들러 생성 및 실행
                ClientHandler clientHandler = new ClientHandler(packet.getAddress(), packet.getPort());
                clients.add(clientHandler);
                new Thread(clientHandler).start();

                // 다른 클라이언트에게 메시지 전송
                broadcast("[" + packet.getAddress().getHostAddress() + ":" + packet.getPort() + "] " + receivedMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void broadcast(String message) {
        for (ClientHandler client : clients) {
            client.send(message);
        }
    }

    private class ClientHandler implements Runnable {
        private InetAddress clientAddress;
        private int clientPort;
        private DatagramSocket clientSocket;

        public ClientHandler(InetAddress clientAddress, int clientPort) {
            this.clientAddress = clientAddress;
            this.clientPort = clientPort;
        }

        @Override
        public void run() {
            try {
                clientSocket = new DatagramSocket();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            clients.remove(this);
        }
        }

        public void send(String message) {
            try {
                byte[] buffer = message.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, clientAddress, clientPort);
                clientSocket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        MessengerServer server = new MessengerServer();
        server.start();
        server.serverSocket.close();
    }
}
