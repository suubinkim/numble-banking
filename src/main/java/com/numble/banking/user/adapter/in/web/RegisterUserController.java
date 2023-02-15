package com.numble.banking.user.adapter.in.web;

import com.numble.banking.common.WebAdapter;
import com.numble.banking.user.application.port.in.RegisterUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterUserController {

    private final RegisterUserUseCase registerUserUseCase;
}
