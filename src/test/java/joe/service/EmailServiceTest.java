package joe.service;

import com.joe.service.EmailService;
import joe.Basetest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author joe
 * @date 2020-03-31 15:50
 */
public class EmailServiceTest extends Basetest {
    @Autowired
    EmailService emailService;

    @Test
    public void sendTest() {
        emailService.send("931", "hello", "931753618@qq.com");
    }
}
