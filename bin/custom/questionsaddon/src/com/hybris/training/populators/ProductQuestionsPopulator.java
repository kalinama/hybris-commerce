package com.hybris.training.populators;

import com.hybris.training.data.QuestionData;
import com.hybris.training.model.QuestionModel;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.springframework.beans.factory.annotation.Required;

public class ProductQuestionsPopulator implements Populator<ProductModel, ProductData> {

    private Converter<QuestionModel, QuestionData> questionConverter;

    @Override
    public void populate(ProductModel productModel, ProductData productData) throws ConversionException {
        productData.setQuestions(questionConverter.convertAll(productModel.getQuestions()));
    }

    @Required
    public void setQuestionConverter(Converter<QuestionModel, QuestionData> questionConverter) {
        this.questionConverter = questionConverter;
    }
}
