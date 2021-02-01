import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
/*        int[] input = new int[size];

        for (int i = 0; i < input.length; i++) {
            input[i] = scanner.nextInt();
        }

        int minimumValue = IntStream.of(input).min().orElse(Integer.MAX_VALUE);*/

        int minimumValue = Integer.MAX_VALUE;
        int tempValue;
        for (int i = 0; i < size; i++) {
            tempValue = scanner.nextInt();
            if (tempValue < minimumValue) {
                minimumValue = tempValue;
            }
        }
        System.out.println(minimumValue);


    }
}