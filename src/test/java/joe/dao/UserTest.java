package joe.dao;

import com.joe.dao.UserMapper;
import joe.Basetest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author joe
 * @date 2020-03-25 15:49
 */
public class UserTest extends Basetest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void insertTest() {
        System.out.println(userMapper.insert(null));
    }

    @Test
    public void selectByEmailTest() {
        System.out.println(userMapper.selectByEmail("931@qq.com"));
    }
}
