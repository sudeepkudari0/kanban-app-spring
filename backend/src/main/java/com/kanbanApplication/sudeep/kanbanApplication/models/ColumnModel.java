package com.kanbanApplication.sudeep.kanbanApplication.models;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class ColumnModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "column_id")
    private Long id;

    private String columnName;
    
    @JsonBackReference("board-columns")
    @ManyToOne
    @JoinColumn(name = "board_id", referencedColumnName = "board_id")
    private Board board;

    @JsonManagedReference("column-tasks")
    @OneToMany(mappedBy = "columnModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskModel> tasks = new ArrayList<>();

    // Constructors, getters, setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<TaskModel> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskModel> tasks) {
        this.tasks = tasks;
    }

    // Helper method to add a task to the column
    public void addTask(TaskModel task) {
        tasks.add(task);
        task.setColumnModel(this);
    }
    
    // Helper method to remove a task from the column
    public void removeTask(TaskModel task) {
        tasks.remove(task);
        task.setColumnModel(null);
    }
}

