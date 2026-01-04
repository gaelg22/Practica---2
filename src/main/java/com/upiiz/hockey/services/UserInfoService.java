package com.upiiz.hockey.services;

import com.upiiz.hockey.UserInfo;
import com.upiiz.hockey.repositories.UserInfoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository repo;

    public List<UserInfo> findAll() { return repo.findAll(); }
    public Optional<UserInfo> findById(Long id) { return repo.findById(id); }
    public UserInfo save(UserInfo info) { return repo.save(info); }
    public void delete(Long id) { repo.deleteById(id); }
}