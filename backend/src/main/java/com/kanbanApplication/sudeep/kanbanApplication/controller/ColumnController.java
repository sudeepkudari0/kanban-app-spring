package com.kanbanApplication.sudeep.kanbanApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kanbanApplication.sudeep.kanbanApplication.models.Board;
import com.kanbanApplication.sudeep.kanbanApplication.models.ColumnModel;
import com.kanbanApplication.sudeep.kanbanApplication.service.BoardService;
import com.kanbanApplication.sudeep.kanbanApplication.service.ColumnService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class ColumnController {

    private final ColumnService columnService;

    @Autowired
    public ColumnController(ColumnService columnService) {
        this.columnService = columnService;
    }

    @Autowired
    private BoardService boardService;

    @PostMapping("/createcolumn/{boardId}")
    public ResponseEntity<ColumnModel> createColumn(@PathVariable Long boardId, @RequestBody ColumnModel columnModel) {
        Board board = boardService.getById(boardId);
        columnModel.setBoard(board);
        ColumnModel createdColumn = columnService.insert(columnModel);
        return ResponseEntity.ok(createdColumn);
    }

    @GetMapping("/columns/{boardId}")
    public ResponseEntity<List<ColumnModel>> getColumnsByBoardId(@PathVariable Long boardId) {
        List<ColumnModel> columns = columnService.getColumnsByBoardId(boardId);
        return ResponseEntity.ok(columns);
    }

}
