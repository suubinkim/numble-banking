package com.numble.banking.user.application.port.out;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class JwtCommand {

    private final String token;
    private final String id;
}
