package com.numble.banking.account.application.service;

import com.numble.banking.account.application.port.in.CreateAccountUseCase;
import com.numble.banking.account.application.port.out.CreateAccountPort;
import com.numble.banking.common.UseCase;
import com.numble.banking.user.application.port.in.UserCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class CreateAccountService implements CreateAccountUseCase {

    private final CreateAccountPort createAccountPort;

    @Override
    public void createAccount(UserCommand command) {
        createAccountPort.createAccount(command);
    }
}
