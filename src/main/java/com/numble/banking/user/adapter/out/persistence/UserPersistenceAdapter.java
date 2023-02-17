package com.numble.banking.user.adapter.out.persistence;

import com.numble.banking.common.PersistenceAdapter;
import com.numble.banking.user.application.port.in.UserCommand;
import com.numble.banking.user.application.port.out.GetUserPort;
import com.numble.banking.user.application.port.out.InsertUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class UserPersistenceAdapter implements GetUserPort, InsertUserPort {

    private final UserRepository userRepository;

    @Override
    public int countByLoginId(String loginId) {
        return userRepository.countByLoginId(loginId);
    }

    @Override
    public void registerUser(UserCommand command) {
        UserJpaEntity user = new UserJpaEntity(command.getLoginId(),command.getPassword());
        userRepository.save(user);
    }
}
