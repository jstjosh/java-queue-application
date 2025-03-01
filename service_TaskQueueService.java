package service;

import model.Task;
import java.util.LinkedList;
import java.util.Queue;

public class TaskQueueService {
    private Queue<Task> queue = new LinkedList<>();

    // Enqueue a task
    public void enqueue(Task task) {
        queue.add(task);
    }

    // List tasks
    public Queue<Task> listTasks() {
        return new LinkedList<>(queue); // Return a copy to avoid modification
    }

    // Dequeue a task
    public Task dequeue() {
        return queue.poll(); // poll() returns null if the queue is empty
    }
}
