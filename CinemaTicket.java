import java.util.Scanner;

public class CinemaTicket {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        char[][] seats = {{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', },
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', },
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', },
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', },
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', },
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', },
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', },
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', },
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }};
        
        int seatCount = 100;
        int seatRow = 10;
        int seatColumn = 10;

        while (seatCount >= 0) {
            System.out.println("Hoş Geldiniz");
            printSeats(seats);
            System.out.println("Kaç tane bilet almak istiyorsunuz: ");
            int requestCount = input.nextInt();

            while (seatCount < requestCount) {
                System.out.println("Maalesef o kadar boş yer kalmadı. Boş koltuk sayısı: " + seatCount);
                printSeats(seats);
                System.out.println("Kaç tane almak istiyorsunuz: ");
                requestCount = input.nextInt();
            }


            input.nextLine();

            for (int i = 0; i < requestCount; i++) {
                System.out.println("İstediğiniz koltuk sırasını ve sütununu seçiniz (C 5 gibi): ");
                String inputString = input.nextLine().toUpperCase();

                String[] parts = inputString.split(" ");

                char rowChar = parts[0].charAt(0);
                int col = Integer.parseInt(parts[1]);
            
                int row = rowChar - 'A';
                int column = col - 1;

                if (seats[row][column] == ' ') {
                    seats[row][column] = 'X';
                    seatCount--;
                    System.out.println("Koltuk başarıyla alındı.");
                    printSeats(seats);
                }
                else {
                    System.out.println("Maalesef bu koltuk dolu başka koltuk seçiniz.");
                    printSeats(seats);
                }

            }

            if (seatCount == 0) {
                System.out.println("Başka boş koltuk kalmadı.");
                printSeats(seats);
                break;
            }

        }
        input.close();
    }

    public static void printSeats(char[][] array) {

        System.out.print("  ");
        for (int i = 1; i < 11; i++) {
            System.out.print(i + "|");
        }

        System.out.println();
        System.out.println("-----------------------");

        for (int i = 'A'; i < 'K'; i++) {
            System.out.print((char) i);

            for (int j = 0; j < 10; j++) {
                System.out.print("|" + array[i - 'A'][j]);

                if (j == 9) {
                    System.out.println("|");
                }
            }

            System.out.println("-----------------------");

        }



    }
}
