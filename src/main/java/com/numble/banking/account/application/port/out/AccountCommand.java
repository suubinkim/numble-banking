package com.numble.banking.account.application.port.out;

import com.numble.banking.account.domain.Account;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;


@Data
@NoArgsConstructor
public class AccountCommand {

    @NotNull
    Long id;

    @NotNull
    BigInteger balance;

    public AccountCommand(Account account) {
        this.id = account.getId();
        this.balance = account.getBalance();
    }
}
