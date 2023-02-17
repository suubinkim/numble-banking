package com.numble.banking.User.application.service;

import com.numble.banking.user.application.port.in.UserCommand;
import com.numble.banking.user.application.port.out.GetUserPort;
import com.numble.banking.user.application.port.out.InsertUserPort;
import com.numble.banking.user.application.service.RegisterUserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RegisterUserServiceTest {

//    private final GetUserPort getUserPort = Mockito.mock(GetUserPort.class);
//    private final InsertUserPort insertUserPort = Mockito.mock(InsertUserPort.class);
//    private final RegisterUserService userService = new RegisterUserService(getUserPort, insertUserPort);

    @Autowired
    RegisterUserService userService;

    @Test
    void registerUser() {
        UserCommand command = new UserCommand("loginId", "password");
        userService.registerUser(command);
    }

}