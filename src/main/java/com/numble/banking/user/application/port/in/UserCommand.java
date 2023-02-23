package com.numble.banking.user.application.port.in;

import com.numble.banking.user.adapter.out.persistence.UserJpaEntity;
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

    public UserCommand(UserJpaEntity user) {
        this.loginId = user.getLoginId();
        this.password = user.getPassword();
    }
}
