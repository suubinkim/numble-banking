package com.numble.banking.account.adapter.out.persistence;

import com.numble.banking.account.application.port.out.CreateAccountPort;
import com.numble.banking.account.application.port.out.GetAccountPort;
import com.numble.banking.account.domain.Account;
import com.numble.banking.common.PersistenceAdapter;
import com.numble.banking.user.adapter.out.persistence.UserJpaEntity;
import com.numble.banking.user.adapter.out.persistence.UserRepository;
import com.numble.banking.user.application.port.in.UserCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.math.BigInteger;


@RequiredArgsConstructor
@PersistenceAdapter
public class AccountPersistenceAdapter implements GetAccountPort, CreateAccountPort {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;


    @Override
    public Account getAccount(Long userId) {
        AccountJpaEntity accountJpa = accountRepository.findByUserId(userId);
        return new Account(accountJpa);
    }

    @Override
    public void createAccount(UserCommand command) {

        // userId 조회
        UserJpaEntity userJpa = userRepository.findByLoginId(command.getLoginId())
                .orElseThrow(() -> new UsernameNotFoundException("Can't find " + command.getLoginId()));

        AccountJpaEntity entity = new AccountJpaEntity();
        entity.setUser(userJpa);
        entity.setAccountName(command.getLoginId());
        entity.setBalance(BigInteger.valueOf(0));

        accountRepository.save(entity);
    }
}
