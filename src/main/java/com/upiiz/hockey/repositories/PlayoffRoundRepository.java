package com.upiiz.hockey.repositories;

import com.upiiz.hockey.PlayoffRound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayoffRoundRepository extends JpaRepository<PlayoffRound, Long> {
}
