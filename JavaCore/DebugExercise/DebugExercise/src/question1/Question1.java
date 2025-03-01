package question1;

public class Question1 {
	public static void main(String[] args) {

		int[] numbers = { -1, 1, 3, 5, -5, -8 };
		int maxValue = getMaxValue(numbers);
		int minValue = getMinValue(numbers);

		System.out.println("Max Value: " + maxValue);
		System.out.println("Min Value: " + minValue);
	}

	public static int getMaxValue(int[] numbers) {
		int maxValue = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] < maxValue) {
				maxValue = numbers[i];
			}
		}
		return maxValue;
	}

	public static int getMinValue(int[] numbers) {
		int minValue = numbers[0];
		for (int i = 1; i < numbers.length - 1; i++) {
			if (numbers[i] < minValue) {
				minValue = numbers[i];
			}
		}
		return minValue;
	}
}
