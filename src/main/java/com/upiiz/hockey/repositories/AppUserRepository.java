package com.upiiz.hockey.repositories;

import com.upiiz.hockey.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
