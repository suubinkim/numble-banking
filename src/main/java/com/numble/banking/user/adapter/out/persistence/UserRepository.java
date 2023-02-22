package com.numble.banking.user.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserJpaEntity,Long> {

    Optional<UserJpaEntity> findByLoginId(String loginId);

    List<UserJpaEntity> findAll();

    int countByLoginId(String loginId);
}
