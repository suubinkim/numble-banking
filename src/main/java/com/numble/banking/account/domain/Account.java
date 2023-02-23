package com.numble.banking.account.domain;

import com.numble.banking.account.adapter.out.persistence.AccountJpaEntity;
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

    public Account(AccountJpaEntity jpaEntity) {
        this.id = jpaEntity.getId();
        this.balance = jpaEntity.getBalance();
    }
}
