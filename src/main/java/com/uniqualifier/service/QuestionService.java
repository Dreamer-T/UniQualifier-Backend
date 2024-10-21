package com.uniqualifier.service;

import com.uniqualifier.mapper.QuestionMapper;
import com.uniqualifier.mapper.SearchHistoryMapper;
import com.uniqualifier.model.Question;
import com.uniqualifier.model.SearchHistory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionService {

    private final QuestionMapper questionMapper;
    private final SearchHistoryMapper searchHistoryMapper;

    public QuestionService(QuestionMapper questionMapper, SearchHistoryMapper searchHistoryMapper) {
        this.questionMapper = questionMapper;
        this.searchHistoryMapper = searchHistoryMapper;
    }

    public List<Question> searchQuestions(String keyword) {
        List<Question> questions = questionMapper.findByQuestionTextLike("%" + keyword + "%");
        SearchHistory history = new SearchHistory();
        history.setQuery(keyword);
        history.setResultCount(questions.size());
        searchHistoryMapper.insert(history);
        return questions;
    }
}
