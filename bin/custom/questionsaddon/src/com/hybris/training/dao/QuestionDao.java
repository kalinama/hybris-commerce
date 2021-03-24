package com.hybris.training.dao;

import com.hybris.training.model.QuestionModel;

import java.util.Date;
import java.util.List;

public interface QuestionDao {
    List<QuestionModel> findQuestionsCreatedAfterDate(Date date);
    List<QuestionModel> findQuestions();
}
