package com.kanbanApplication.sudeep.kanbanApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kanbanApplication.sudeep.kanbanApplication.models.Board;
import com.kanbanApplication.sudeep.kanbanApplication.service.BoardService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class BoardController {

    @Autowired
    private BoardService boardService;
    
    @PostMapping("/createboard")
    public ResponseEntity<String> createBoard(@RequestBody Board board) {
        String status = boardService.insert(board);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @GetMapping("/boards/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable Long id) {
        Board board = boardService.getById(id);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @GetMapping("/allboards")
    public ResponseEntity<List<Board>> getAllBoards(){
        List<Board> boards = boardService.getAllBoards();
        return new ResponseEntity<>(boards, HttpStatus.OK);
    }

    @GetMapping("/deleteboard/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        String status = boardService.deleteBoardById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PutMapping("/updateboard/{id}")
    public ResponseEntity<String> updateBoard(@PathVariable Long id,@RequestBody Board board) {
        String status = boardService.update(board, id);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }
}
