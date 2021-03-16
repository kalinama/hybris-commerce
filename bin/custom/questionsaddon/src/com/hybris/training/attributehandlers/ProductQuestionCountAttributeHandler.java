package com.hybris.training.attributehandlers;

import com.hybris.training.model.QuestionModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.attribute.AbstractDynamicAttributeHandler;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

public class ProductQuestionCountAttributeHandler extends AbstractDynamicAttributeHandler<Integer, ProductModel> {
    @Override
    public Integer get(ProductModel model) {
        Set<QuestionModel> questions = Optional.ofNullable(model.getQuestions())
                .orElse(Collections.emptySet());
        return questions.size();
    }
}
