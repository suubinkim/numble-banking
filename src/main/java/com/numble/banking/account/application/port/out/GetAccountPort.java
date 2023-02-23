package com.numble.banking.account.application.port.out;

import com.numble.banking.account.domain.Account;

public interface GetAccountPort {

    Account getAccount(Long userId);
}
