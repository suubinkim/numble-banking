package com.numble.banking.user.adapter.in.web;

import com.numble.banking.common.WebAdapter;
import com.numble.banking.user.application.port.in.UserCommand;
import com.numble.banking.user.application.port.out.JwtCommand;
import com.numble.banking.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@WebAdapter
@EnableWebMvc
@RestController
@RequiredArgsConstructor
public class LoginUserController {

    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    @PostMapping(value = "/user/login")
    public ResponseEntity<?> loginUser(@RequestBody UserCommand command) throws Exception {

        authenticate(command.getLoginId(), command.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(command.getLoginId());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtCommand(token, userDetails.getUsername()));
    }


    private void authenticate(String id, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(id, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
