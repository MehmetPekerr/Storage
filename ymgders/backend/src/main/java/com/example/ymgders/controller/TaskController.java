package com.example.ymgders.controller;

import com.example.ymgders.model.Task;
import com.example.ymgders.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("API is working");
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> getTasks() {
        try {
            List<Task> tasks = taskRepository.findAll();
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        try {
            System.out.println("Received task: " + task);
            
            if (task == null || task.getDescription() == null || task.getDescription().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Description cannot be empty");
            }
            
            task.setDescription(task.getDescription().trim());
            Task savedTask = taskRepository.save(task);
            
            System.out.println("Saved task: " + savedTask);
            return ResponseEntity.ok(savedTask);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        try {
            taskRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
