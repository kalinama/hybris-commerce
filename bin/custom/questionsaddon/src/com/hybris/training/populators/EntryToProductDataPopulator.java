package com.hybris.training.populators;

import com.hybris.training.data.QuestionData;
import com.hybris.training.model.QuestionModel;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;
import java.util.Map.Entry;

public class EntryToProductDataPopulator implements Populator<Entry<ProductModel, List<QuestionModel>>, ProductData> {

    private Converter<QuestionModel, QuestionData> questionConverter;
    private Populator<ProductModel, ProductData> productPopulator;

    @Override
    public void populate(Entry<ProductModel, List<QuestionModel>> productModelListEntry, ProductData productData) throws ConversionException {
        productPopulator.populate(productModelListEntry.getKey(), productData);
        productData.setQuestions(questionConverter.convertAll(productModelListEntry.getValue()));
    }

    @Required
    public void setQuestionConverter(Converter<QuestionModel, QuestionData> questionConverter) {
        this.questionConverter = questionConverter;
    }

    @Required
    public void setProductPopulator(Populator<ProductModel, ProductData> productPopulator) {
        this.productPopulator = productPopulator;
    }
}
