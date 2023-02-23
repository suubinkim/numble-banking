package com.numble.banking.Account.adapter.in.web;


import com.numble.banking.account.adapter.in.web.GetAccountController;
import com.numble.banking.account.application.port.in.GetAccountUseCase;
import com.numble.banking.user.application.port.in.RegisterUserUseCase;
import com.numble.banking.user.application.port.in.UserCommand;
import com.numble.banking.util.JwtTokenUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@MockBean(JpaMetamodelMappingContext.class)
@WebMvcTest(controllers = GetAccountController.class)
class GetAccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetAccountUseCase getAccountUseCase;

    @MockBean
    private RegisterUserUseCase registerUserUseCase;

    @MockBean
    private JwtTokenUtil jwtTokenUtil;

    @Test
    @WithUserDetails(value = "loginId2")
    void testGetAccount() throws Exception {

        UserCommand command = new UserCommand("loginId", "password");

        mockMvc.perform(get("/account"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

}