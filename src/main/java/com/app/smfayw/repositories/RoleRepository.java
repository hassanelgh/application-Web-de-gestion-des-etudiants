package com.app.smfayw.repositories;

import com.app.smfayw.entites.NomRole;
import com.app.smfayw.entites.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, NomRole> {
}
