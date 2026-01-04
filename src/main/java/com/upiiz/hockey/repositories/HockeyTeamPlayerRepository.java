package com.upiiz.hockey.repositories;

import com.upiiz.hockey.HockeyTeamPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HockeyTeamPlayerRepository extends JpaRepository<HockeyTeamPlayer, Long> {
}
