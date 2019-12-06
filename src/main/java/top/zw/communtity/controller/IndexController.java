package top.zw.communtity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.zw.communtity.dto.PaginationDTO;
import top.zw.communtity.dto.QuestionDTO;
import top.zw.communtity.mapper.QuestionMapper;
import top.zw.communtity.mapper.UserMapper;
import top.zw.communtity.model.Question;
import top.zw.communtity.model.User;
import top.zw.communtity.service.QuestionService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(
                        Model model,
                        @RequestParam(name = "page",defaultValue = "1")Integer page,
                        @RequestParam(name = "size",defaultValue = "5") Integer size){

         PaginationDTO paginationDTO = questionService.list(page,size);
        model.addAttribute("pagination",paginationDTO);
        return "index";
    }
}
