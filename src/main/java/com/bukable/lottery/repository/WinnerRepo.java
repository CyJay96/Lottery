package com.bukable.lottery.repository;

import com.bukable.lottery.domain.Winner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WinnerRepo extends JpaRepository<Winner, Long> {
}
