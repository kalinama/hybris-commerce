package com.hybris.training.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

public class ProductMinAgePopulator implements Populator<ProductModel, ProductData> {
    @Override
    public void populate(ProductModel productModel, ProductData productData) throws ConversionException {
        productData.setMinAge(productModel.getMinAge());
    }
}
