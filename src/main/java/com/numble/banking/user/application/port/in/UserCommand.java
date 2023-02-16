package com.numble.banking.user.application.port.in;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserCommand {

    @NotNull
    String loginId;

    @NotNull
    String password;

    public UserCommand(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }
}
