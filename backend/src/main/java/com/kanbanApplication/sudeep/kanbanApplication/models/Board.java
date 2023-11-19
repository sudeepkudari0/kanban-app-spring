package com.kanbanApplication.sudeep.kanbanApplication.models;



import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Board {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    private String description;
    
    @JsonManagedReference("board-columns")
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ColumnModel> columns = new ArrayList<>();
   
    @JsonManagedReference("Board-tasks")
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskModel> tasks = new ArrayList<>();
    
    private String name;

    public Board(Long id, String description, List<ColumnModel> columns, String name) {
        this.id = id;
        this.description = description;
        this.columns = columns;
        this.name = name;
    }

    public Board() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ColumnModel> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnModel> columns) {
        this.columns = columns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    // Helper method to add a column to the board
    public void addColumn(ColumnModel column) {
        columns.add(column);
        column.setBoard(this);
    }
    
    // Helper method to remove a column from the board
    public void removeColumn(ColumnModel column) {
        columns.remove(column);
        column.setBoard(null);
    }
}
