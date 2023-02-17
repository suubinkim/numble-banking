package com.numble.banking.user.application.service;

import com.numble.banking.common.UseCase;
import com.numble.banking.exception.ErrorCode;
import com.numble.banking.exception.UserException;
import com.numble.banking.user.application.port.in.RegisterUserUseCase;
import com.numble.banking.user.application.port.in.UserCommand;
import com.numble.banking.user.application.port.out.GetUserPort;
import com.numble.banking.user.application.port.out.InsertUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class RegisterUserService implements RegisterUserUseCase {

    private final GetUserPort getUserPort;
    private final InsertUserPort insertUserPort;

    @Override
    public void registerUser(UserCommand command) {
        // 아이디 중복 확인
        int count = getUserPort.countByLoginId(command.getLoginId());
        if (count != 0) {
            throw new UserException(ErrorCode.DUPLICATE_LOGIN_ID);
        }
        /** TODO : 비밀번호 암호화 */

        // 로그인 정보 저장
        insertUserPort.registerUser(command);
    }
}
