package com.hybris.training.populators;

import com.hybris.training.data.QuestionData;
import com.hybris.training.model.QuestionModel;
import com.hybris.training.services.QuestionService;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.springframework.beans.factory.annotation.Required;

import java.util.Set;

public class ProductQuestionsPopulator implements Populator<ProductModel, ProductData> {

    private Converter<QuestionModel, QuestionData> questionConverter;
    private QuestionService questionService;

    @Override
    public void populate(ProductModel productModel, ProductData productData) throws ConversionException {
        Set<QuestionModel> approvedQuestions =  questionService.getApprovedQuestions(productModel);
        productData.setQuestions(questionConverter.convertAll(approvedQuestions));
    }

    @Required
    public void setQuestionConverter(Converter<QuestionModel, QuestionData> questionConverter) {
        this.questionConverter = questionConverter;
    }

    @Required
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }
}
