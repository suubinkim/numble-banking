package com.numble.banking.account.domain;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @Column(nullable = false)
    private BigInteger balance;
}
