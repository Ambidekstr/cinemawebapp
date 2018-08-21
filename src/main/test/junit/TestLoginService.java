package junit;

import com.anatoliivoloshyn.cinemawebapp.entity.Language;
import com.anatoliivoloshyn.cinemawebapp.entity.Role;
import com.anatoliivoloshyn.cinemawebapp.entity.User;
import com.anatoliivoloshyn.cinemawebapp.service.LoginService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestLoginService {

    private LoginService loginService;
    private String login;
    private String password;
    private User user;

    @Before
    public void setUp(){
        loginService = new LoginService();
        login = "aavolosh@gmail.com";
        password = "admin";
        user = new User();
        user.setUserId(1L);
        user.setPassword(password);
        user.setLogin(login);
        user.setLanguage(new Language(1L));
        user.setRole(new Role(1L));
        user.setName("Anatolii");
        user.setSurname("Voloshyn");
    }

    @Test
    public void testLogin(){
        Assert.assertEquals(user,loginService.login(login,password));
        Assert.assertNull(loginService.login("",password));
        Assert.assertNull(loginService.login(login,""));
        return;
    }

    @After
    public void tearDown(){
        user = null;
        password = null;
        login = null;
        loginService = null;
    }
}
