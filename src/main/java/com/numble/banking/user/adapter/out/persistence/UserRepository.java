package com.numble.banking.user.adapter.out.persistence;

import com.numble.banking.user.application.port.in.UserCommand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserJpaEntity,Long> {

    Optional<UserJpaEntity> findById(Long id);

    List<UserJpaEntity> findAll();

    int countByLoginId(String loginId);

    void save(UserCommand command);
}
