package junit;

import com.anatoliivoloshyn.cinemawebapp.entity.Role;
import com.anatoliivoloshyn.cinemawebapp.entity.User;
import com.anatoliivoloshyn.cinemawebapp.service.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestLoginService {

    private UserService userService;
    private String login;
    private String password;
    private User user;

    @Before
    public void setUp(){
        userService = new UserService();
        login = "aavolosh@gmail.com";
        password = "admin";
        user = new User();
        user.setUserId(1L);
        user.setPassword(password);
        user.setLogin(login);
        user.setRole(new Role(1L));
        user.setName("Anatolii");
        user.setSurname("Voloshyn");
    }

    @Test
    public void testLogin(){
        Assert.assertEquals(user, userService.login(login,password));
        Assert.assertNull(userService.login("",password));
        Assert.assertNull(userService.login(login,""));
        return;
    }

    @After
    public void tearDown(){
        user = null;
        password = null;
        login = null;
        userService = null;
    }
}
