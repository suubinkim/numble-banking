package com.numble.banking.user.application.port.out;

import com.numble.banking.user.application.port.in.UserCommand;

public interface InsertUserPort {

    void registerUser(UserCommand command);
}
