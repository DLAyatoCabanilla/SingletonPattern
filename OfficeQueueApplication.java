import java.util.Scanner;

public class OfficeQueueApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QueueManagementSystem queueSystem = QueueManagementSystem.getInstance();

        System.out.println("WELCOME TO THE PAG-IBIG QUEUE MANAGEMENT SYSTEM");

        while (true) {
            System.out.println("""
                    
                    Choose an option:
                    [1] Generate Queue for 20 Customers
                    [2] View Current Queue Status (Online Monitoring)
                    [3] Reset a Specific Help Desk's Queue Number
                    [4] Exit
                    """);

            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("\nAssigning 20 customers to the help desks:");
                    for (int i = 0; i < 20; i++) {
                        queueSystem.assignNewQueue();
                    }
                    System.out.println();
                }
                case 2 -> {
                    System.out.println("\nCurrent Queue Status:");
                    queueSystem.displayCurrentQueues();
                    System.out.println();
                }
                case 3 -> {
                    System.out.println("\nReset Queue Number:");
                    System.out.print("Select Desk (1 for A, 2 for B, 3 for C): ");
                    int desk = scanner.nextInt();
                    System.out.print("Enter new starting queue number: ");
                    int newQueueStart = scanner.nextInt();
                    queueSystem.resetDeskQueue(desk, newQueueStart);
                    System.out.println();
                }
                case 4 -> {
                    System.out.println("Exiting the system. Have a great day!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
