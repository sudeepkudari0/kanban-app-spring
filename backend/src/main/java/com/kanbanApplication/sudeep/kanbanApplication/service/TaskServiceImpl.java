package com.kanbanApplication.sudeep.kanbanApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanbanApplication.sudeep.kanbanApplication.models.Board;
import com.kanbanApplication.sudeep.kanbanApplication.models.ColumnModel;
import com.kanbanApplication.sudeep.kanbanApplication.models.TaskModel;
import com.kanbanApplication.sudeep.kanbanApplication.repository.TaskModelRepository;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskModelRepository taskModelRepository;

    @Autowired
    private ColumnService columnService;

    @Autowired
    private BoardService boardService;
    @Override
    public List<TaskModel> getTasksByColumnIdAndBoardId(Long column_id, Long board_id) {
        return taskModelRepository.findTasksByBoardAndColumn(column_id, board_id);
    }

    @Override
    public TaskModel getById(Long columnId) {
        Optional<TaskModel> findByid = taskModelRepository.findById(columnId);
        if(findByid.isPresent()) {
            return  findByid.get();
        }
        return null;
    }

    @Override
    public TaskModel insert(TaskModel taskModel) {
        return taskModelRepository.save(taskModel);
    }

    @Override
    public String update(TaskModel taskModel, Long id) {
        if (taskModelRepository.existsById(id)) {
            taskModel.setTask_id(id);
            taskModelRepository.save(taskModel);
            return "Task updated successfully";
        }else{
            return "Task not found";
        }
    }

    @Override
    public String deleteTaskById(Long id) {
        if(taskModelRepository.existsById(id)) {
            taskModelRepository.deleteById(id);
            return "Task deleted successfully";
        }else{
            return "Task not found";
        }
    }

    @Override
    public TaskModel addTaskToColumn(Long boardId, Long columnId, TaskModel taskModel) {
        Board board = boardService.getById(boardId);
        ColumnModel columnModel = columnService.getById(columnId);
        taskModel.setBoard(board);
        taskModel.setColumnModel(columnModel);
        return taskModelRepository.save(taskModel);
    }
    
}
