package com.kanbanApplication.sudeep.kanbanApplication.models;



import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;


@Entity
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long task_id;

    private String name;
    private String description;

    @JsonBackReference("column-tasks")
    @ManyToOne
    @JoinColumn(name = "column_id", referencedColumnName = "column_id")
    @JsonProperty("column_id")
    private ColumnModel columnModel;

    @JsonBackReference("Board-tasks")
    @ManyToOne
    @JoinColumn(name = "board_id", referencedColumnName = "board_id")
    @JsonProperty("board_id")
    private Board board;

    public TaskModel() {
    }

    public TaskModel(Long task_id, String name, String description, ColumnModel columnModel) {
        this.task_id = task_id;
        this.name = name;
        this.description = description;
        this.columnModel = columnModel;
    }

    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ColumnModel getColumnModel() {
        return columnModel;
    }

    public void setColumnModel(ColumnModel columnModel) {
        this.columnModel = columnModel;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
