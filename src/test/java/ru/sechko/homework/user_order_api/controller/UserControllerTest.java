package ru.sechko.homework.user_order_api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.sechko.homework.user_order_api.model.User;
import ru.sechko.homework.user_order_api.service.UserService;


@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllUsersWithUserSummaryView() {
        User user = new User();
        user.setId(1L);
        user.setName("TEST");
        user.setEmail("test@test.com");

    }
}
