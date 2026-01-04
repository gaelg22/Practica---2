package com.upiiz.hockey.services;

import com.upiiz.hockey.RoundStats;
import com.upiiz.hockey.repositories.RoundStatsRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class RoundStatsService {

    @Autowired
    private RoundStatsRepository repo;

    public List<RoundStats> findAll() { return repo.findAll(); }
    public Optional<RoundStats> findById(Long id) { return repo.findById(id); }
    public RoundStats save(RoundStats stats) { return repo.save(stats); }
    public void delete(Long id) { repo.deleteById(id); }
}