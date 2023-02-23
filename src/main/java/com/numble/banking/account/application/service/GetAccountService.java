package com.numble.banking.account.application.service;

import com.numble.banking.account.application.port.in.GetAccountUseCase;
import com.numble.banking.account.application.port.out.AccountCommand;
import com.numble.banking.account.application.port.out.GetAccountPort;
import com.numble.banking.account.domain.Account;
import com.numble.banking.common.UseCase;
import com.numble.banking.user.application.port.in.UserCommand;
import com.numble.banking.user.application.port.out.GetUserPort;
import com.numble.banking.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class GetAccountService implements GetAccountUseCase {

    private final GetAccountPort getAccountPort;
    private final GetUserPort getUserPort;

    @Override
    public AccountCommand getAccount(UserCommand command) {
        // userId 조회
        User user = getUserPort.findByLoginId(command.getLoginId());
        // account 조회
        Account account = getAccountPort.getAccount(user.getId());
        return new AccountCommand(account);
    }
}
