package com.kanbanApplication.sudeep.kanbanApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kanbanApplication.sudeep.kanbanApplication.models.TaskModel;

public interface TaskModelRepository extends JpaRepository<TaskModel, Long> {

    @Query("SELECT t FROM TaskModel t " +
           "JOIN t.columnModel c " +
           "JOIN c.board b " +
           "WHERE b.id = :boardId AND c.id = :columnId")
    List<TaskModel> findTasksByBoardAndColumn(@Param("boardId") Long boardId, @Param("columnId") Long columnId);
}
