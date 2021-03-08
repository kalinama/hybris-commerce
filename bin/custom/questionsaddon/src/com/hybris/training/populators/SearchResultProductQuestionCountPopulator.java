package com.hybris.training.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commerceservices.search.resultdata.SearchResultValueData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

public class SearchResultProductQuestionCountPopulator implements Populator<SearchResultValueData, ProductData> {
    @Override
    public void populate(SearchResultValueData searchResultValueData, ProductData productData) throws ConversionException {
        productData.setQuestionCount((Integer) searchResultValueData.getValues().get("questionCount"));
    }
}
