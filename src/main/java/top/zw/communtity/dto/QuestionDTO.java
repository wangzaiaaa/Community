package top.zw.communtity.dto;

import lombok.Data;
import top.zw.communtity.model.User;

@Data
public class QuestionDTO {
    private int id;
    private String title;
    private String description;
    private String tag;
    private long gmtCreate;
    private long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;

}
