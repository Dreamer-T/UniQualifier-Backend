package com.uniqualifier.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uniqualifier.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper extends BaseMapper<Question> {
    @Select("SELECT * FROM questions WHERE question_text LIKE CONCAT('%', #{keyword}, '%')")
    List<Question> findByQuestionTextLike(String keyword);
}
