package com.keremturak.repository;

import com.keremturak.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {



    Boolean existsByEmail(String email);

    Optional<User> findByEmailIgnoreCaseAndPassword(String email, String password);
}
