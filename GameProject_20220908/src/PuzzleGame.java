import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PuzzleGame extends JFrame {
	private JButton[][] buttons;
	private List<Integer> cardValues;
	private int size;
	private int ClickRow1, ClickCol1, ClickRow2, ClickCol2;
	private long startTime;
	
	
	public PuzzleGame(int size) {
		this.size = size;
		this.cardValues = generateCardValues();
		this.buttons = new JButton[size][size];
		this.ClickRow1 = -1;
		this.ClickCol1 = -1;
		this.ClickRow2 = -1;
		this.ClickCol2 = -1;
		
		UI();
	}
	
	private void UI() {
		setTitle("Puzzle Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 700); 
		setLayout(new BorderLayout());

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(size, size));
		
		for (int i = 0; i < size; i++) {
			for (int j=0; j < size; j++ ) {
				
				JPanel panel = new JPanel();
				panel.setLayout(new BorderLayout());
				
				buttons[i][j] = new JButton();
				buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 24));
				buttons[i][j].setBackground(Color.LIGHT_GRAY);
				buttons[i][j].setOpaque(true);
	            buttons[i][j].addActionListener(new CardClickListener(i, j));


	            panel.add(buttons[i][j], BorderLayout.CENTER); 
                gamePanel.add(panel);  
               
			}
		}
		 JPanel controlPanel = new JPanel();
	     controlPanel.setLayout(new FlowLayout());
	     JButton startButton = new JButton("시작");
	     JButton endButton = new JButton("종료");

	     startButton.addActionListener(new ActionListener() {
	    	 @Override
	            public void actionPerformed(ActionEvent e) {
	                startGame();
	            }
	        });
	        
	     endButton.addActionListener(new ActionListener() {
	    	 @Override
	            public void actionPerformed(ActionEvent e) {
	                endGame();
	            }
	        });
	        
	        controlPanel.add(startButton);
	        controlPanel.add(endButton);

	        add(gamePanel, BorderLayout.CENTER);
	        add(controlPanel, BorderLayout.SOUTH);

	        setCards();
	        setLocationRelativeTo(null);
	}
	
	private List<Integer> generateCardValues() {
		List <Integer> values = new ArrayList <>();
		for (int i = 0; i<size * size / 2; i++) {
			values.add(i);
			values.add(i);
		}
		Collections.shuffle(values);
		return values;
	}
	
	private void setCards() {
		int count = 0;
		for (int i = 0; i < size; i++) {
			for (int j=0; j < size; j++) {
				 buttons[i][j].setText("");
	             buttons[i][j].setEnabled(true);
			}
		}
	}
	
	 private void startGame() {
	        startTime = System.currentTimeMillis();
	        setCards();
	    }

	    private void endGame() {
	        long endTime = System.currentTimeMillis();
	        long elapsedTime = endTime - startTime;
	        String formattedTime = formatTime(elapsedTime);

	        JOptionPane.showMessageDialog(this, "Game Over!\n 시간: " + formattedTime);

	       
	        setCards();
	    }
	    
	    private String formatTime(long elapsedTime) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
	        return dateFormat.format(new Date(elapsedTime));
	    }

	    private class CardClickListener implements ActionListener {
	        private int row, col;

	        public CardClickListener(int row, int col) {
	            this.row = row;
	            this.col = col;
	        }
	    
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (ClickRow1 == -1 && ClickCol1 == -1) {
				ClickRow1 = row;
				ClickCol1 = col;
				buttons[row][col].setText(String.valueOf(cardValues.get(row * size + col)));
				 
			} else if (ClickRow2 == -1 && ClickCol2 == -1 && (row != ClickRow1 || col != ClickCol1)) {
                ClickRow2 = row;
                ClickCol2 = col;
                buttons[row][col].setText(String.valueOf(cardValues.get(row * size + col)));
                new Thread(new checkMatch()).start();
		}
	}
		
		 private class checkMatch implements Runnable {

		        @Override
		        public void run() {
		        	try {
		        		Thread.sleep(1000);
		        		
		        		
		                boolean isMatch = cardValues.get(ClickRow1 * size + ClickCol1)
		                        .equals(cardValues.get(ClickRow2 * size + ClickCol2));
		                
		                SwingUtilities.invokeLater(() -> {
		                	 if (isMatch) {
				                    buttons[ClickRow1][ClickCol1].setEnabled(false);
				                    buttons[ClickRow2][ClickCol2].setEnabled(false);
				                } else {
				                    buttons[ClickRow1][ClickCol1].setText("");
				                    buttons[ClickRow2][ClickCol2].setText("");
				                }
		                	 
		                	    ClickRow1 = -1;
				                ClickCol1 = -1;
				                ClickRow2 = -1;
				                ClickCol2 = -1;
				                
				                if (isGameClear()) {
				                	showClearMessage();
				                }
		                });
		                 

		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		        }
		        
		        private boolean isGameClear() {
		        	for (int i = 0; i<size; i++) {
		        		for (int j = 0; j < size; j++) {
		        			if (buttons[i][j].isEnabled()) {
		        				return false;
		        			}
		        		}
		        	}
		        	return true;
		        }
		        private void showClearMessage() {
		        	long endTime = System.currentTimeMillis();
		            long elapsedTime = endTime - startTime;
		            String formattedTime = formatTime(elapsedTime);

		            JOptionPane.showMessageDialog(PuzzleGame.this, "Clear!\n 시간 : " + formattedTime);

		            
		            setCards();
		        }
		        }
		    
		 

		    public static void main(String[] args) {
		        SwingUtilities.invokeLater(() -> {
		            PuzzleGame game = new PuzzleGame(4);
		            game.setVisible(true);
		        });
		    }
	}
}
