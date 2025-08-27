import java.util.Scanner;
public class FixedDepositApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FDManagement bank = new FDManagement(10);
        int choice;

        do {
            System.out.println("\n===== Fixed Deposit Management Menu =====");
            System.out.println("1. Open FD");
            System.out.println("2. View FD");
            System.out.println("3. Withdraw FD");
            System.out.println("4. View All FDs");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Account No: ");
                        long accNo = sc.nextLong();
                        sc.nextLine();
                        System.out.print("Enter Holder Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Principal Amount: ");
                        double amt = sc.nextDouble();
                        System.out.print("Enter Term (Years): ");
                        int term = sc.nextInt();
                        bank.openFD(accNo, name, amt, term);
                    }
                    case 2 -> {
                        System.out.print("Enter Account No: ");
                        long vAcc = sc.nextLong();
                        bank.viewFD(vAcc);
                    }
                    case 3 -> {
                        System.out.print("Enter Account No: ");
                        long wAcc = sc.nextLong();
                        System.out.print("Enter Years Passed: ");
                        int years = sc.nextInt();
                        bank.withdrawFD(wAcc, years);
                    }
                    case 4 -> bank.viewAllFDs();
                    case 5 -> System.out.println("Exiting FD Management...");
                    default -> System.out.println("Invalid choice!");
                }
            }
            catch (InvalidAmountException | AccountNotFoundException | PrematureWithdrawalException e) {
                System.out.println("Custom Exception: " + e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 5);

        sc.close();
    }
}
