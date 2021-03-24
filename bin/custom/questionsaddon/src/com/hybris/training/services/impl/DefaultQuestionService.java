package com.hybris.training.services.impl;

import com.hybris.training.dao.QuestionDao;
import com.hybris.training.model.QuestionModel;
import com.hybris.training.services.QuestionService;
import de.hybris.platform.core.model.product.ProductModel;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Required;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DefaultQuestionService implements QuestionService {

    private QuestionDao questionDao;

    @Override
    public List<QuestionModel> getQuestionsCreatedAfterDate(Date date) {
        return questionDao.findQuestionsCreatedAfterDate(date);
    }

    @Override
    public List<QuestionModel> getQuestions() {
        return questionDao.findQuestions();
    }

    @Override
    public Set<QuestionModel> getApprovedQuestions(ProductModel product) {
        return CollectionUtils
                .emptyIfNull(product.getQuestions())
                .stream()
                .filter(QuestionModel::getApproved)
                .collect(Collectors.toSet());
    }

    @Required
    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }
}
