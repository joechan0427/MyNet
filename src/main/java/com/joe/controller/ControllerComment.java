package com.joe.controller;

import com.joe.dao.CommentMapper;
import com.joe.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author joe
 * @date 2020-03-25 16:40
 */
@Controller
public class ControllerComment {

    @Autowired
    CommentMapper commentMapper;

    @RequestMapping("/getByID.do")
    @ResponseBody
    public Object getbyID(String ID) {
        Comment comment = commentMapper.selectByPrimaryKey(ID);
        return comment;
    }
}
