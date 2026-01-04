package com.upiiz.hockey.services;

import com.upiiz.hockey.UserStatsPicks;
import com.upiiz.hockey.repositories.UserStatsPicksRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class UserStatsPicksService {

    @Autowired
    private UserStatsPicksRepository repo;

    public List<UserStatsPicks> findAll() { return repo.findAll(); }
    public Optional<UserStatsPicks> findById(Long id) { return repo.findById(id); }
    public UserStatsPicks save(UserStatsPicks picks) { return repo.save(picks); }
    public void delete(Long id) { repo.deleteById(id); }
}