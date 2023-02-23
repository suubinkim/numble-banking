package com.numble.banking.account.adapter.out.persistence;

import com.numble.banking.account.application.port.out.GetAccountPort;
import com.numble.banking.account.domain.Account;
import com.numble.banking.common.PersistenceAdapter;
import com.numble.banking.user.adapter.out.persistence.UserRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@PersistenceAdapter
public class AccountPersistenceAdapter implements GetAccountPort {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;


    @Override
    public Account getAccount(Long userId) {
        AccountJpaEntity accountJpa = accountRepository.findByUserId(userId);
        return new Account(accountJpa);
    }
}
