package com.numble.banking.user.adapter.in.web;

import com.numble.banking.account.application.port.in.CreateAccountUseCase;
import com.numble.banking.common.WebAdapter;
import com.numble.banking.user.application.port.in.RegisterUserUseCase;
import com.numble.banking.user.application.port.in.UserCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@WebAdapter
@EnableWebMvc
@RestController
@RequiredArgsConstructor
public class RegisterUserController {

    private final RegisterUserUseCase registerUserUseCase;
    private final CreateAccountUseCase createAccountUseCase;

    @PostMapping(value = "/user")
    public ResponseEntity<Void> registerUser(@RequestBody UserCommand command) {

        registerUserUseCase.registerUser(command);

        // 회원 등록시 로그인 아이디로 계좌 생성
        createAccountUseCase.createAccount(command);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
