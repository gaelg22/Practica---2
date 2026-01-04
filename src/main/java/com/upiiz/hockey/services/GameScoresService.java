package com.upiiz.hockey.services;

import com.upiiz.hockey.GameScores;
import com.upiiz.hockey.repositories.GameScoresRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class GameScoresService {

    @Autowired
    private GameScoresRepository repo;

    public List<GameScores> findAll() { return repo.findAll(); }
    public Optional<GameScores> findById(Long id) { return repo.findById(id); }
    public GameScores save(GameScores scores) { return repo.save(scores); }
    public void delete(Long id) { repo.deleteById(id); }
}