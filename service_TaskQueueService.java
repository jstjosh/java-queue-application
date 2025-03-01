package service;

import model.Task;
import java.util.LinkedList;
import java.util.Queue;

public class TaskQueueService {
    private Queue<Task> queue = new LinkedList<>();

    public void enqueue(Task task) {
        queue.add(task);
    }

    public Queue<Task> listTasks() {
        return queue;
    }

    public Task dequeue() {
        return queue.poll();
    }
}