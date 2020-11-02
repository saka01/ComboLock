import java.util.Scanner;

public class ComboLockTester {
    public static void main(String[] args) {

        //Create variables and take user input for secret keys
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int t;
        Scanner in = new Scanner(System.in);
        System.out.print("Set secret number 1: ");
        num1 = in.nextInt();
        System.out.print("Set secret number 2: ");
        num2 = in.nextInt();
        System.out.print("Set secret number 3: ");
        num3 = in.nextInt();

        //Create object of class ComboLock
        ComboLock comboLock = new ComboLock(num1, num2, num3);
        while (true) {
            System.out.print("Enter number of right ticks: ");
            t = in.nextInt();
            comboLock.turnRight(t);
            System.out.print("Enter number of left ticks: ");
            t = in.nextInt();
            comboLock.turnLeft(t);
            System.out.print("Enter number of right ticks: ");
            t = in.nextInt();
            comboLock.turnRight(t);
            if (!comboLock.open()) {
                comboLock.reset();
                System.out.println("Combination is incorrect. Try again.");
            } else {
                System.out.println("Successfully open.");
                break;
            }
        }
    }
}