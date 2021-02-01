import java.util.Scanner;

class FixingStringIndexOutOfBoundsException {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        int index = scanner.nextInt();

        System.out.println(index < string.length() && index >= 0 ? string.charAt(index) : " Out of bounds!");
    }
}