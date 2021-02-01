import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean ordered = true;
        Boolean ascending = null;
        int prev = scanner.nextInt();
        int next = scanner.nextInt();


        while (next != 0) {
            if (prev != next && ordered) {
                if (ascending == null) {
                    ascending = prev < next;
                    continue;
                }

                if (ascending) {
                    if (prev > next) {
                        ordered = false;
                    }
                } else {
                    if (prev < next) {
                        ordered = false;
                    }
                }
            }
            prev = next;
            next = scanner.nextInt();
        }

        System.out.println(ordered);



        /*
         while (temp != 0) {
            integers.add(temp);
            temp = scanner.nextInt();
        }

        for (int i = 0; i < integers.size() - 1 && ordered; i++) {
            if (!integers.get(i).equals(integers.get(i + 1))) {
                if (ascending == null) {
                    ascending = integers.get(i) < integers.get(i + 1);
                }

                if (ascending) {
                    if (integers.get(i) > integers.get(i + 1)) {
                        ordered = false;
                    }
                } else {
                    if (integers.get(i) < integers.get(i + 1)) {
                        ordered = false;
                    }
                }
            }
        }
         */
    }
}