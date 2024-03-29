package com.trainning.module1.practical.task.repository;

import com.trainning.module1.practical.task.entitty.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    public AppUser findByUsername(String username);
}
