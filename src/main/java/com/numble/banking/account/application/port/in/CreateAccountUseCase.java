package com.numble.banking.account.application.port.in;

import com.numble.banking.user.application.port.in.UserCommand;

public interface CreateAccountUseCase {

    void createAccount(UserCommand command);
}
