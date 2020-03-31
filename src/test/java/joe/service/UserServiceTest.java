package joe.service;

import com.joe.entity.User;
import com.joe.service.UserService;
import joe.Basetest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author joe
 * @date 2020-03-31 21:00
 */
public class UserServiceTest extends Basetest {

    @Autowired
    UserService userService;

    @Test
    public void SignUpTest() {
        System.out.println(userService.SignUp(new User(null,"joe","123","931753618@qq.com",null,null,null,null)));
    }
}
