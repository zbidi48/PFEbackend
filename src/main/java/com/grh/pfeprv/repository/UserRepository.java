package com.grh.pfeprv.repository;

import com.grh.pfeprv.domaine.User;
import com.grh.pfeprv.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

    @Query(value = "SELECT count(id) FROM public.users WHERE type = 'employee'", nativeQuery = true)
    long nbEmp();

    @Query(value = "SELECT count(id) FROM public.users WHERE type = 'condidat'", nativeQuery = true)
    long nbCondidat();


}
