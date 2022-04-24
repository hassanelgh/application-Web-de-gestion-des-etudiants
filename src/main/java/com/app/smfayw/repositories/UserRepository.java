package com.app.smfayw.repositories;

import com.app.smfayw.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
