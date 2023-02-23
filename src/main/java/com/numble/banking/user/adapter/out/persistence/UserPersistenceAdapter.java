package com.numble.banking.user.adapter.out.persistence;

import com.numble.banking.common.PersistenceAdapter;
import com.numble.banking.security.UserDetailsImpl;
import com.numble.banking.user.application.port.in.UserCommand;
import com.numble.banking.user.application.port.out.GetUserPort;
import com.numble.banking.user.application.port.out.InsertUserPort;
import com.numble.banking.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@RequiredArgsConstructor
@PersistenceAdapter
public class UserPersistenceAdapter implements GetUserPort, InsertUserPort, UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public int countByLoginId(String loginId) {
        return userRepository.countByLoginId(loginId);
    }

    @Override
    public User findByLoginId(String userLoginId) {
        UserJpaEntity userJpa = userRepository.findByLoginId(userLoginId)
                .orElseThrow(() -> new UsernameNotFoundException("Can't find " + userLoginId));
        return new User(userJpa);
    }

    @Override
    public void registerUser(UserCommand command) {
        UserJpaEntity user = new UserJpaEntity(command.getLoginId(), command.getPassword());
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserJpaEntity user = userRepository.findByLoginId(username)
                .orElseThrow(() -> new UsernameNotFoundException("Can't find " + username));
        return new UserDetailsImpl(user);
    }
}
