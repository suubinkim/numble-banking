package com.numble.banking.account.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigInteger;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Account {

    @Getter
    private Long id;

    @Getter
    private BigInteger balance;
}
