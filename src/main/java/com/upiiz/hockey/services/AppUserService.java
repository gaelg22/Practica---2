package com.upiiz.hockey.services;



import com.upiiz.hockey.AppUser;
import com.upiiz.hockey.repositories.AppUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository repo;

    public List<AppUser> findAll() { return repo.findAll(); }
    public Optional<AppUser> findById(Long id) { return repo.findById(id); }
    public AppUser save(AppUser user) { return repo.save(user); }
    public void delete(Long id) { repo.deleteById(id); }
}
