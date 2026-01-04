package com.upiiz.hockey.services;

import com.upiiz.hockey.HockeyTeam;
import com.upiiz.hockey.repositories.HockeyTeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class HockeyTeamService {

    @Autowired
    private HockeyTeamRepository repo;

    public List<HockeyTeam> findAll() { return repo.findAll(); }
    public Optional<HockeyTeam> findById(Long id) { return repo.findById(id); }
    public HockeyTeam save(HockeyTeam team) { return repo.save(team); }
    public void delete(Long id) { repo.deleteById(id); }
}