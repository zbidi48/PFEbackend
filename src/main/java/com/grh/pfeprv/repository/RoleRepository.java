package com.grh.pfeprv.repository;

import com.grh.pfeprv.domaine.Role;
import com.grh.pfeprv.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long>
{

    Optional <Role> findByName(ERole name);
}