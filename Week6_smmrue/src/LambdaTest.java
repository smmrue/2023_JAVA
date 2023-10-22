interface ArrayProcessing {
	double apply(double[] array);
}

public class LambdaTest {
	
	public static final ArrayProcessing maxer = array -> {
		if (array.length == 0) {
			throw new IllegalArgumentException("배열이 비었습니다.");
		}
		
		double max = array[0];
		for (double num : array) {
			if (num > max) {
				max = num;
			}
		}
		return max;
	};
	
	public static final ArrayProcessing miner = array -> {
		if (array.length == 0) {
			throw new IllegalArgumentException("배열이 비었습니다.");
		}
		
		double min = array[0];
		for (double num : array) {
			if (num < min) {
				min = num;
			}
		}
		return min;
	};
	
	public static final ArrayProcessing sumer = array -> {
		if (array.length == 0) {
			return 0.0;
		}
		double sum = 0.0;
		for (double num : array) {
			sum += num;
		}
		return sum / array.length;
	};
	
	public static void main(String[] args) {
		double[] numbers = {1.5, 2.5, 3.5, 4.5, 5.5};
		
		System.out.println("최대값: " + maxer.apply(numbers));
        System.out.println("최소값: " + miner.apply(numbers));
        System.out.println("평균값: " + sumer.apply(numbers));
	}
		
	}


