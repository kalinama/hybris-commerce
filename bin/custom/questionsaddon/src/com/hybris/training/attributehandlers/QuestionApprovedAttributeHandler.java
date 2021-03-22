package com.hybris.training.attributehandlers;

import com.hybris.training.model.QuestionModel;
import de.hybris.platform.servicelayer.model.attribute.AbstractDynamicAttributeHandler;

public class QuestionApprovedAttributeHandler extends AbstractDynamicAttributeHandler<Boolean, QuestionModel> {
    @Override
    public Boolean get(QuestionModel model) {
        return model.getAnswer() != null
                && !model.getAnswer().isEmpty();
    }
}
