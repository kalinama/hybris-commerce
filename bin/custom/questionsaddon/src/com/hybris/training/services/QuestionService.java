package com.hybris.training.services;

import com.hybris.training.model.QuestionModel;

import java.util.Date;
import java.util.List;

public interface QuestionService {
    List<QuestionModel> getQuestionsCreatedAfterDate(Date date);
}
