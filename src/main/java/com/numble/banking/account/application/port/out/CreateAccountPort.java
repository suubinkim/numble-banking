package com.numble.banking.account.application.port.out;

import com.numble.banking.user.application.port.in.UserCommand;

public interface CreateAccountPort {

    void createAccount(UserCommand command);
}
