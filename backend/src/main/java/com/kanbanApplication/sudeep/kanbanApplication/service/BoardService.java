package com.kanbanApplication.sudeep.kanbanApplication.service;

import java.util.List;

import com.kanbanApplication.sudeep.kanbanApplication.models.Board;

public interface BoardService {
    
    public List<Board> getAllBoards();

    public Board getById(Long id);

    public String insert(Board board);

    public String update(Board board, Long id);

    public String deleteBoardById(Long id);
}
