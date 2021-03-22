package com.hybris.training.services;

import com.hybris.training.model.QuestionModel;
import de.hybris.platform.core.model.product.ProductModel;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface QuestionService {
    List<QuestionModel> getQuestionsCreatedAfterDate(Date date);
    Set<QuestionModel> getApprovedQuestions(ProductModel product);
}
