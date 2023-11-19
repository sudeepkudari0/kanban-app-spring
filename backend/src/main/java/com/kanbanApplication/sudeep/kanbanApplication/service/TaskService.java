package com.kanbanApplication.sudeep.kanbanApplication.service;

import java.util.List;

import com.kanbanApplication.sudeep.kanbanApplication.models.TaskModel;

public interface TaskService {
    
    public List<TaskModel> getTasksByColumnIdAndBoardId(Long column_id, Long board_id);

    public TaskModel addTaskToColumn(Long boardId, Long columnId, TaskModel taskModel);
    
    public TaskModel getById(Long columnId);

    public TaskModel insert(TaskModel taskModel);

    public String update(TaskModel taskModel, Long id);

    public String deleteTaskById(Long id);
}