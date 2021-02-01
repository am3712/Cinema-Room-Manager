package cinema;

import java.util.Scanner;

public class Cinema {

    static char[][] cinema;
    static Scanner scanner;
    static int numOfRows, numOfSeats;
    static int numOfPurchased = 0;
    static int currentIncome = 0;
    static int totalIncome;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        //Cinema
        System.out.println("Enter the number of rows:");
        numOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        numOfSeats = scanner.nextInt();
        cinema = new char[numOfRows][numOfSeats];
        fillArray(cinema);

        showMenu();
    }


    private static void showMenu() {
        int menuItem;
        while (true) {
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            menuItem = scanner.nextInt();
            switch (menuItem) {
                case 1:
                    printCinema();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    showStatistics();
                    break;
                case 0:
                    return;
            }
        }
    }


    private static void fillArray(char[][] cinema) {
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[0].length; j++) {
                cinema[i][j] = 'S';
            }
        }
        totalIncome = getTotalIncome();
    }

    private static void buyTicket() {
        int ticketPrice;
        while (true) {
            System.out.println("Enter a row number:");
            int customerRowNum = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int customerSeatNum = scanner.nextInt();

            if (customerRowNum > numOfRows || customerSeatNum > numOfSeats) {
                System.out.println("Wrong input!");
                continue;
            }

            if (cinema[customerRowNum - 1][customerSeatNum - 1] == 'B') {
                System.out.println("That ticket has already been purchased!");
                continue;
            }

            System.out.println("Ticket price: ");
            System.out.print("$");
            int frontRows = numOfRows / 2;
            System.out.println((numOfRows * numOfSeats <= 60
                    || customerRowNum <= frontRows) ? (ticketPrice = 10) : (ticketPrice = 8));
            cinema[customerRowNum - 1][customerSeatNum - 1] = 'B';
            currentIncome += ticketPrice;
            numOfPurchased++;
            break;
        }
    }

    private static void printCinema() {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= cinema[0].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < cinema.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < cinema[0].length; j++) {
                System.out.print(cinema[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void showStatistics() {
        System.out.println("Number of purchased tickets: " + numOfPurchased);
        System.out.printf("Percentage: %.2f%%\n", (numOfPurchased * 100f) / (numOfRows * numOfSeats));
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }

    private static int getTotalIncome() {
        if (numOfRows * numOfSeats <= 60) {
            return numOfRows * numOfSeats * 10;
        } else {
            int frontRows = numOfRows / 2;
            return frontRows * numOfSeats * 10 + (numOfRows - frontRows) * numOfSeats * 8;
        }
    }
}