package com.hybris.training.interceptors;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;


public class ProductQuestionCountPrepareInterceptor implements PrepareInterceptor<ProductModel> {
    @Override
    public void onPrepare(ProductModel productModel, InterceptorContext interceptorContext) throws InterceptorException {
        productModel.setQuestionCount(productModel.getQuestions().size());
    }
}
