package com.numble.banking.User.application.service;

import com.numble.banking.security.JwtAuthenticationEntryPoint;
import com.numble.banking.user.adapter.out.persistence.UserPersistenceAdapter;
import com.numble.banking.user.application.port.in.UserCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootTest
class LoginUserServiceTest {

//    private final GetUserPort getUserPort = Mockito.mock(GetUserPort.class);
//    private final InsertUserPort insertUserPort = Mockito.mock(InsertUserPort.class);
//    private final RegisterUserService userService = new RegisterUserService(getUserPort, insertUserPort);

    @Autowired
    UserPersistenceAdapter userPersistenceAdapter;

    @MockBean
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;


    @Test
    void loginUser() {
        UserCommand command = new UserCommand("loginId2", "password");
        UserDetails userDetails = userPersistenceAdapter.loadUserByUsername(command.getLoginId());
        System.out.println(userDetails.getUsername());
    }

}