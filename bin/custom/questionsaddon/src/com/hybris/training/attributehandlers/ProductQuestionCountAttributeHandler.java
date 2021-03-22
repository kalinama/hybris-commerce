package com.hybris.training.attributehandlers;

import com.hybris.training.services.QuestionService;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.attribute.AbstractDynamicAttributeHandler;
import org.springframework.beans.factory.annotation.Required;

public class ProductQuestionCountAttributeHandler extends AbstractDynamicAttributeHandler<Integer, ProductModel> {

    private QuestionService questionService;

    @Override
    public Integer get(ProductModel model) {
        return questionService.getApprovedQuestions(model).size();
    }

    @Required
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }
}
