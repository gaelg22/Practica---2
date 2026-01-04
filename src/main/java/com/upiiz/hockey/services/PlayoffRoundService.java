package com.upiiz.hockey.services;

import com.upiiz.hockey.PlayoffRound;
import com.upiiz.hockey.repositories.PlayoffRoundRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class PlayoffRoundService {

    @Autowired
    private PlayoffRoundRepository repo;

    public List<PlayoffRound> findAll() { return repo.findAll(); }
    public Optional<PlayoffRound> findById(Long id) { return repo.findById(id); }
    public PlayoffRound save(PlayoffRound round) { return repo.save(round); }
    public void delete(Long id) { repo.deleteById(id); }
}