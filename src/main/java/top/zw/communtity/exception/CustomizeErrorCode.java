package top.zw.communtity.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{
    QUESTION_NOT_FOUND(2001,"你找的问题不存在了，要不换个试试"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何问题或评论进行回复"),
    NOT_LOGIN(2003,"未登录不能评论，请先登录"),
    SYS_ERROR(2004,"服务不可用"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或者不存在"),
    COMMENT_NOT_FOUND(2006,"回复的评论不存在了"),
    CONTENT_IS_EMPTY(2007,"输入内容不能为空")
    ;
    private String message;
    private Integer code;



    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    CustomizeErrorCode(Integer code,String message) {
        this.message = message;
        this.code = code;
    }
}
