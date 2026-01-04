package com.upiiz.hockey.repositories;

import com.upiiz.hockey.HockeyTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HockeyTeamRepository extends JpaRepository<HockeyTeam, Long> {
}
