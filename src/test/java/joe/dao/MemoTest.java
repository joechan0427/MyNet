package joe.dao;

import com.joe.dao.MemoMapper;
import com.joe.dao.UserMapper;
import joe.Basetest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author joe
 * @date 2020-03-25 15:49
 */
public class MemoTest extends Basetest {
    @Autowired
    MemoMapper memoMapper;

    @Test
    public void selectTest() {
        System.out.println(memoMapper.selectByPrimaryKey("1"));
    }
}
