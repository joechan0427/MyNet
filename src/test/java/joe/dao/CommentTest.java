package joe.dao;

import com.joe.dao.CommentMapper;
import com.joe.dao.MemoMapper;
import com.joe.entity.Comment;
import joe.Basetest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author joe
 * @date 2020-03-25 15:49
 */
public class CommentTest extends Basetest {
    @Autowired
    CommentMapper commentMapper;

    @Test
    public void selectTest() {
        System.out.println(commentMapper.selectByPrimaryKey("1"));
    }

    @Test
    public void insertTest() {
//        System.out.println(new Date());
        System.out.println(commentMapper.insertSelective(new Comment("2","1000",new Date(),"好")));
    }
}
