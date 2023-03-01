package com.numble.banking.Account.application.service;

import com.numble.banking.account.application.port.out.AccountCommand;
import com.numble.banking.account.application.service.CreateAccountService;
import com.numble.banking.account.application.service.GetAccountService;
import com.numble.banking.security.JwtAuthenticationEntryPoint;
import com.numble.banking.user.application.port.in.UserCommand;
import com.numble.banking.user.application.service.RegisterUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
class CreateAccountServiceTest {

    @Autowired
    CreateAccountService createAccountService;

    @Autowired
    RegisterUserService userService;

    @Autowired
    GetAccountService accountService;


    @MockBean
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Test
    @Rollback
    void createAccountTest() {
        // 유저 등록
        UserCommand command = new UserCommand("loginId4", "password");
        userService.registerUser(command);
        // 계좌 등록
        createAccountService.createAccount(command);

        // 계좌 확인
        AccountCommand account = accountService.getAccount(command);
        System.out.println(account.toString());

        Assertions.assertEquals(account.getAccountName(), command.getLoginId());
    }

}