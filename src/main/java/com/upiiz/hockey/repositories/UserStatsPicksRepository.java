package com.upiiz.hockey.repositories;

import com.upiiz.hockey.UserStatsPicks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStatsPicksRepository extends JpaRepository<UserStatsPicks, Long> {
}
