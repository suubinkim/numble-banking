package com.numble.banking.Account.application.service;

import com.numble.banking.account.application.port.out.AccountCommand;
import com.numble.banking.account.application.port.out.GetAccountPort;
import com.numble.banking.account.application.service.GetAccountService;
import com.numble.banking.security.JwtAuthenticationEntryPoint;
import com.numble.banking.user.application.port.in.UserCommand;
import com.numble.banking.user.application.port.out.GetUserPort;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class GetAccountServiceTest {

//    private final GetAccountPort getAccountPort = Mockito.mock(GetAccountPort.class);
//    private final GetUserPort getUserPort = Mockito.mock(GetUserPort.class);
//    private final GetAccountService accountService = new GetAccountService(getAccountPort,getUserPort);

    @Autowired
    GetAccountService accountService;

    @MockBean
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Test
    void getAccount() {
        UserCommand command = new UserCommand("loginId2", "password");
        AccountCommand account = accountService.getAccount(command);

        System.out.println(account.toString());
    }

}