import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        int numberOfTriples = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i + 2 < size
                    && arr[i] == arr[i + 1] - 1
                    && arr[i] == arr[i + 2] - 2) {
                numberOfTriples++;
            }

        }
        System.out.println(numberOfTriples);
    }
}