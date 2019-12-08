package top.zw.communtity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.zw.communtity.dto.QuestionDTO;
import top.zw.communtity.mapper.QuestionMapper;
import top.zw.communtity.service.QuestionService;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Integer id, Model model){
        QuestionDTO questionDTO = questionService.getById(id);
        //增加阅读数
        questionService.inView(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
