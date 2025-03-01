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
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Task Description: ");
                    String desc = scanner.nextLine();
                    Task task = new Task(id, desc);
                    queueService.enqueue(task);
                    System.out.println("Task added.");
                    break;
                case 2:
                    System.out.println("Current Tasks in Queue:");
                    for (Task t : queueService.listTasks()) {
                        System.out.println(t);
                    }
                    break;
                case 3:
                    Task removedTask = queueService.dequeue();
                    if (removedTask != null) {
                        System.out.println("Removed Task: " + removedTask);
                    } else {
                        System.out.println("No tasks to remove (queue is empty).");
                    }
                    break;
                case 4:
                    System.out.println("Exiting application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select from 1 to 4.");
            }
        }
        scanner.close();
    }
}