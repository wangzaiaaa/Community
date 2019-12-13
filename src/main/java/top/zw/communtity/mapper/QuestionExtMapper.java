package top.zw.communtity.mapper;

import top.zw.communtity.model.Question;

public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);
}
