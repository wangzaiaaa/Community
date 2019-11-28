package top.zw.communtity.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.zw.communtity.dto.PaginationDTO;

@SpringBootTest
public class questionServiceTest {
    @Autowired
    private QuestionService questionService;

    @Test
    public void listTest(){
        PaginationDTO paginationDTO = questionService.list(1,5);
        System.out.println(paginationDTO);
    }
}
