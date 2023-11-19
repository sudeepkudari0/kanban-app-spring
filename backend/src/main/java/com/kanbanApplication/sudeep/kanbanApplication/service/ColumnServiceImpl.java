package com.kanbanApplication.sudeep.kanbanApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kanbanApplication.sudeep.kanbanApplication.models.ColumnModel;
import com.kanbanApplication.sudeep.kanbanApplication.repository.ColumnModelRepository;

@Service
public class ColumnServiceImpl implements ColumnService{

    @Autowired
    private ColumnModelRepository columnModelRepository;

    @Override
    public ColumnModel getById(Long boardId) {
        Optional<ColumnModel> findByid = columnModelRepository.findById(boardId);
        if(findByid.isPresent()) {
            return  findByid.get();
        }
        return null;
    }

    @Override
    public ColumnModel insert(ColumnModel columnModel) {
            return columnModelRepository.save(columnModel);
    }

    @Override
    public String update(ColumnModel columnModel, Long id) {
        if (columnModelRepository.existsById(id)) {
            columnModel.setId(id);
            columnModelRepository.save(columnModel);
            return "Column updated successfully";
        }else{
            return "Column not found";
        }
    }

    @Override
    public String deleteColumnById(Long id) {
        if(columnModelRepository.existsById(id)) {
            columnModelRepository.deleteById(id);
            return "Column deleted successfully";
        }else{
            return "Column not found";
        }
    }

    @Override
    public List<ColumnModel> getColumnsByBoardId(Long board_id) {
        return columnModelRepository.findByBoardId(board_id);
    }
    
}
