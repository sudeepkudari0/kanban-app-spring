package com.kanbanApplication.sudeep.kanbanApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanbanApplication.sudeep.kanbanApplication.models.ColumnModel;

public interface ColumnModelRepository extends JpaRepository<ColumnModel, Long>  {

    List<ColumnModel> findByBoardId(Long boardId);
}
