package com.upiiz.hockey.repositories;

import com.upiiz.hockey.UserScorePicks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserScorePicksRepository extends JpaRepository<UserScorePicks, Long> {
}