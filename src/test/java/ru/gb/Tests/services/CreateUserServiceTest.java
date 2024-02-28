package ru.gb.Tests.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.gb.Tests.models.User;
import ru.gb.Tests.repository.UserRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CreateUserServiceTest {
    @InjectMocks
    private CreateUserService createUserService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testCreateNewUser() {
        User user = new User();
        user.setUsername("Ivan");
        user.setEmail("123@mail.ru");
        user.setPassword("100");
        user.setRoles("ROLE_USER");
        createUserService.save(user);

        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }


}
