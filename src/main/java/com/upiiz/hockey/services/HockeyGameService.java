package com.upiiz.hockey.services;

import com.upiiz.hockey.HockeyGame;
import com.upiiz.hockey.repositories.HockeyGameRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class HockeyGameService {

    @Autowired
    private HockeyGameRepository repo;

    public List<HockeyGame> findAll() { return repo.findAll(); }
    public Optional<HockeyGame> findById(Long id) { return repo.findById(id); }
    public HockeyGame save(HockeyGame game) { return repo.save(game); }
    public void delete(Long id) { repo.deleteById(id); }
}