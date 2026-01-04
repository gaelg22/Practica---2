package com.upiiz.hockey.services;

import com.upiiz.hockey.UserScorePicks;
import com.upiiz.hockey.repositories.UserScorePicksRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class UserScorePicksService {

    @Autowired
    private UserScorePicksRepository repo;

    public List<UserScorePicks> findAll() { return repo.findAll(); }
    public Optional<UserScorePicks> findById(Long id) { return repo.findById(id); }
    public UserScorePicks save(UserScorePicks picks) { return repo.save(picks); }
    public void delete(Long id) { repo.deleteById(id); }
}