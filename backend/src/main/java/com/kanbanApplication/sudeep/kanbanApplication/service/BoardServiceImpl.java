package com.kanbanApplication.sudeep.kanbanApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanbanApplication.sudeep.kanbanApplication.models.Board;
import com.kanbanApplication.sudeep.kanbanApplication.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    @Override
    public String insert(Board board) {
        boardRepository.save(board);
        return "Board saved successfully";
    }

    @Override
    public Board getById(Long id) {
        Optional<Board> findByid = boardRepository.findById(id);
        if(findByid.isPresent()) {
            return findByid.get();
        }
        return null;
    }

    @Override
    public String deleteBoardById(Long id) {
        if(boardRepository.existsById(id)) {
            boardRepository.deleteById(id);
            return "Board deleted successfully";
        }else{
            return "Board not found";
        }
        
    }

    @Override
    public String update(Board board, Long id) {
        if(boardRepository.existsById(id)) {
            board.setId(id);
            boardRepository.save(board);
            return "Board updated successfully";
        }else{
            return "Board not found";
        }
    }
    
}
