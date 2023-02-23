package com.numble.banking.user.domain;

import com.numble.banking.user.adapter.out.persistence.UserJpaEntity;
import com.numble.banking.user.application.port.in.UserCommand;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    @Getter
    private Long id;

    @Getter
    private String loginId;

    @Getter
    private String password;

    public User(UserJpaEntity userJpa) {
        this.id = userJpa.getId();
        this.loginId = userJpa.getLoginId();
        this.password = userJpa.getPassword();
    }

    public User(UserCommand command) {
        this.loginId = command.getLoginId();
        this.password = command.getPassword();
    }
}
