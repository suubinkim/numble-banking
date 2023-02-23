package com.numble.banking.user.application.port.out;

import com.numble.banking.user.domain.User;

public interface GetUserPort {

    int countByLoginId(String loginId);

    User findByLoginId(String userLoginId);
}
