package com.kanbanApplication.sudeep.kanbanApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanbanApplication.sudeep.kanbanApplication.models.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {


}
