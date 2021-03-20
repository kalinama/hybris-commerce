package com.hybris.training.services.impl;

import com.hybris.training.dao.QuestionDao;
import com.hybris.training.model.QuestionModel;
import com.hybris.training.services.QuestionService;
import org.springframework.beans.factory.annotation.Required;

import java.util.Date;
import java.util.List;

public class DefaultQuestionService implements QuestionService {

    private QuestionDao questionDao;

    @Override
    public List<QuestionModel> getQuestionsCreatedAfterDate(Date date) {
        return questionDao.findQuestionsCreatedAfterDate(date);
    }

    @Required
    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }
}
