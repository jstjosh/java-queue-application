package app;

import model.Task;
import service.TaskQueueService;
import java.util.Scanner;

public class QueueApp {
    public static void main(String[] args) {
        TaskQueueService queueService = new TaskQueueService();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("\n=== Task Queue Menu ===");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            // Get user input and handle invalid inputs
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.nextLine(); // Consume invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Task Description: ");
                    String desc = scanner.nextLine();
                    Task task = new Task(id, desc);
                    queueService.enqueue(task);
                    System.out.println("Task added successfully.");
                    break;
                case 2:
                    System.out.println("Current Tasks in Queue:");
                    if (queueService.listTasks().isEmpty()) {
                        System.out.println("The queue is empty.");
                    } else {
                        for (Task t : queueService.listTasks()) {
                            System.out.println(t);
                        }
                    }
                    break;
                case 3:
                    Task removedTask = queueService.dequeue();
                    if (removedTask != null) {
                        System.out.println("Removed Task: " + removedTask);
                    } else {
                        System.out.println("The queue is empty. No tasks to remove.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting application. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select an option between 1 and 4.");
            }
        }

        // Close scanner to free up resources
        scanner.close();
    }
}
