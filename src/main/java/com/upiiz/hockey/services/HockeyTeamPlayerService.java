package com.upiiz.hockey.services;

import com.upiiz.hockey.HockeyTeamPlayer;
import com.upiiz.hockey.repositories.HockeyTeamPlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class HockeyTeamPlayerService {

    @Autowired
    private HockeyTeamPlayerRepository repo;

    public List<HockeyTeamPlayer> findAll() { return repo.findAll(); }
    public Optional<HockeyTeamPlayer> findById(Long id) { return repo.findById(id); }
    public HockeyTeamPlayer save(HockeyTeamPlayer player) { return repo.save(player); }
    public void delete(Long id) { repo.deleteById(id); }
}
