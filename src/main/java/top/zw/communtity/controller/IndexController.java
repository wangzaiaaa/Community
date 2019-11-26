package top.zw.communtity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String index(HttpServletRequest request, Model model){
        Cookie [] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().endsWith("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }

                }
                break;
            }
        }
        List<QuestionDTO> questionList = questionService.list();
        for (QuestionDTO questionDTO : questionList){
            questionDTO.setDescription("resert");
        }
        model.addAttribute("questions",questionList);
        return "index";
    }
}
