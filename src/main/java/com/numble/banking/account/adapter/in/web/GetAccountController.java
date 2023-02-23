package com.numble.banking.account.adapter.in.web;

import com.numble.banking.account.application.port.in.GetAccountUseCase;
import com.numble.banking.account.application.port.out.AccountCommand;
import com.numble.banking.common.WebAdapter;
import com.numble.banking.security.UserDetailsImpl;
import com.numble.banking.user.application.port.in.UserCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@WebAdapter
@EnableWebMvc
@RestController
@RequiredArgsConstructor
public class GetAccountController {

    private final GetAccountUseCase getAccountUseCase;

    @GetMapping(value = "/account")
    public ResponseEntity<AccountCommand> getAccount(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        UserCommand command = new UserCommand(userDetails.getUser());

        return ResponseEntity.ok(getAccountUseCase.getAccount(command));
    }
}
