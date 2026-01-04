package com.upiiz.hockey.repositories;

import com.upiiz.hockey.HockeyGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HockeyGameRepository extends JpaRepository<HockeyGame, Long> {
}