import java.util.Random;

public class QueueManagementSystem {
    private static QueueManagementSystem instance;

    // Current queue numbers for each help desk
    private int deskAQueue;
    private int deskBQueue;
    private int deskCQueue;

    private final Random random;

    // Private constructor for Singleton
    private QueueManagementSystem() {
        deskAQueue = 1;
        deskBQueue = 1;
        deskCQueue = 1;
        random = new Random();
    }

    // Get Singleton instance
    public static synchronized QueueManagementSystem getInstance() {
        if (instance == null) {
            instance = new QueueManagementSystem();
        }
        return instance;
    }

    // Display the current queue numbers
    public synchronized void displayCurrentQueues() {
        System.out.println("Online Monitoring - Current Queue Numbers:");
        System.out.println("Help Desk A: A-" + deskAQueue);
        System.out.println("Help Desk B: B-" + deskBQueue);
        System.out.println("Help Desk C: C-" + deskCQueue);
    }

    // Assign a new queue number to a random desk
    public synchronized void assignNewQueue() {
        int randomDesk = random.nextInt(3) + 1;

        switch (randomDesk) {
            case 1 -> {
                System.out.println("Assigned to Help Desk A: A-" + deskAQueue);
                deskAQueue++;
            }
            case 2 -> {
                System.out.println("Assigned to Help Desk B: B-" + deskBQueue);
                deskBQueue++;
            }
            case 3 -> {
                System.out.println("Assigned to Help Desk C: C-" + deskCQueue);
                deskCQueue++;
            }
        }
    }

    // Reset a specific desk's queue number
    public synchronized void resetDeskQueue(int desk, int newQueueStart) {
        switch (desk) {
            case 1 -> {
                deskAQueue = newQueueStart;
                System.out.println("Help Desk A queue reset to: A-" + deskAQueue);
            }
            case 2 -> {
                deskBQueue = newQueueStart;
                System.out.println("Help Desk B queue reset to: B-" + deskBQueue);
            }
            case 3 -> {
                deskCQueue = newQueueStart;
                System.out.println("Help Desk C queue reset to: C-" + deskCQueue);
            }
            default -> System.out.println("Invalid desk choice. Please select 1, 2, or 3.");
        }
    }
}
