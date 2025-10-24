package com.senac.juanM27.repository;

import com.senac.juanM27.entity.Role;
import com.senac.juanM27.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(RoleName name);

}
