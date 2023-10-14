import java.util.Scanner;

public class TimerAndStopwatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter '1' to use stopwatch and '2' for timer: ");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            stopwatch();
        } else if (choice.equals("2")) {
            try {
                System.out.print("Enter the number of minutes for the timer: ");
                int minutes = Integer.parseInt(scanner.nextLine());
                int seconds = minutes * 60;
                countdownTimer(seconds);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number of minutes.");
            }
        }
    }

    public static void stopwatch() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press Enter to start the stopwatch.");
        scanner.nextLine();
        long startTime = System.currentTimeMillis();

        try {
            while (true) {
                long currentTime = System.currentTimeMillis();
                long elapsedTime = currentTime - startTime;
                long hours = elapsedTime / 3600000;
                long minutes = (elapsedTime % 3600000) / 60000;
                long seconds = (elapsedTime % 60000) / 1000;
                System.out.printf("\rTime: %02d:%02d:%02d", hours, minutes, seconds);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            // Timer stopped
        }

        System.out.println("\nStopwatch stopped. Press Enter to exit.");
        scanner.nextLine();
    }

    public static void countdownTimer(int seconds) {
        while (seconds > 0) {
            int minutes = seconds / 60;
            int sec = seconds % 60;
            System.out.printf("\rTime Remaining: %02d:%02d", minutes, sec);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Timer stopped
            }
            seconds--;
        }

        System.out.println("\nTime's up!");
    }
}
