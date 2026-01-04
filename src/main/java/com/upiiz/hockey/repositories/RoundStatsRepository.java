package com.upiiz.hockey.repositories;

import com.upiiz.hockey.RoundStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundStatsRepository extends JpaRepository<RoundStats, Long> {
}
