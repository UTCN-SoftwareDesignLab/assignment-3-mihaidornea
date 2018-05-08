package service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import sample.entity.User;
import sample.entity.builder.UserBuilder;
import sample.repository.UserRepository;
import sample.service.user.UserService;
import sample.service.user.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService = new UserServiceImpl(userRepository);

    @Before
    public void setup(){

        User user = new UserBuilder()
                .setEmail("mihai@test.com")
                .setUsername("mihaidornea")
                .setPassword("123A_3")
                .setRole("Administrator")
                .build();

        List<User> userList = new ArrayList<>();
        userList.add(user);

        when(userRepository.findByUsername("mihaidornea")).thenReturn(user);
        when(userRepository.findAll()).thenReturn(userList);
    }

    @Test
    public void findByUsernameTest(){
        Assert.assertNotNull(userService.findByUsername("mihaidornea"));
    }

    @Test
    public void findAllTest(){
        Assert.assertEquals(userService.findAll().size(), 1);
    }


}
