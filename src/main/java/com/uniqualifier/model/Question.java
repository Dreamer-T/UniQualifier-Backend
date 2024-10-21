package com.uniqualifier.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("questions")
public class Question {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String questionText;
    private String answer;
    private String subject;
    private String difficulty;
    private LocalDateTime createdAt;
}
