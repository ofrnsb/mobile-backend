package com.lsb1.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lsb1.Models.userData;

public interface userRepo extends JpaRepository<userData, Long> {}
