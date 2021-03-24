package com.hybris.training.interceptors;

import com.hybris.training.model.QuestionModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;


public class ProductQuestionCountPrepareInterceptor implements PrepareInterceptor<ProductModel> {
    @Override
    public void onPrepare(ProductModel productModel, InterceptorContext interceptorContext) throws InterceptorException {
        Set<QuestionModel> questions = Optional.ofNullable(productModel.getQuestions())
                .orElse(Collections.emptySet());
        productModel.setQuestionCount(questions.size());
    }
}
