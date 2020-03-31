package joe;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author joe
 * @date 2020-03-18 16:18
 */

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:Application-mail.xml", "classpath:Application-Context.xml"})
public class Basetest {
}
