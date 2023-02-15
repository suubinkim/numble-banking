package com.numble.banking.user.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    @Getter
    private Long id;

    @Getter
    private String loginId;
}
