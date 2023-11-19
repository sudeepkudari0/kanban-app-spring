package com.kanbanApplication.sudeep.kanbanApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kanbanApplication.sudeep.kanbanApplication.models.TaskModel;
import com.kanbanApplication.sudeep.kanbanApplication.service.ColumnService;
import com.kanbanApplication.sudeep.kanbanApplication.service.TaskService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Autowired
    private ColumnService columnService;
    
     @GetMapping("/board/{boardId}/column/{columnId}")
    public ResponseEntity<List<TaskModel>> getTasksByBoardAndColumn(
            @PathVariable Long boardId, @PathVariable Long columnId) {
        List<TaskModel> tasks = taskService.getTasksByColumnIdAndBoardId(boardId, columnId);
        return ResponseEntity.ok(tasks);
    }

    @PostMapping(value = "/board/{boardId}/column/{columnId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskModel> addTaskToColumn(
            @PathVariable Long boardId, @PathVariable Long columnId, @RequestBody TaskModel taskModel) {
        TaskModel addedTask = taskService.addTaskToColumn(boardId, columnId, taskModel);
        return ResponseEntity.ok(addedTask);
    }
    

}
