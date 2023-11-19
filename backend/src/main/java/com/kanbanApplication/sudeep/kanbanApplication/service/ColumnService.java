package com.kanbanApplication.sudeep.kanbanApplication.service;

import java.util.List;

import com.kanbanApplication.sudeep.kanbanApplication.models.ColumnModel;

public interface ColumnService {

    public List<ColumnModel> getColumnsByBoardId(Long boardId);

    public ColumnModel getById(Long boardId);

    public ColumnModel insert(ColumnModel columnModel);

    public String update(ColumnModel columnModel, Long id);

    public String deleteColumnById(Long id);
}
