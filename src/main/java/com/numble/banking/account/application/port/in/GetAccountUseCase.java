package com.numble.banking.account.application.port.in;

import com.numble.banking.account.application.port.out.AccountCommand;
import com.numble.banking.user.application.port.in.UserCommand;

public interface GetAccountUseCase {

    AccountCommand getAccount(UserCommand command);
}
