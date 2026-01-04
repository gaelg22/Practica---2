package com.upiiz.hockey.repositories;

import com.upiiz.hockey.GameScores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameScoresRepository extends JpaRepository<GameScores, Long> {
}