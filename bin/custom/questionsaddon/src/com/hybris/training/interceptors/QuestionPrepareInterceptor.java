package com.hybris.training.interceptors;

import com.hybris.training.model.QuestionModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import de.hybris.platform.servicelayer.keygenerator.KeyGenerator;
import org.springframework.beans.factory.annotation.Required;


public class QuestionPrepareInterceptor implements PrepareInterceptor<QuestionModel> {

    private KeyGenerator keyGenerator;

    @Override
    public void onPrepare(QuestionModel questionModel, InterceptorContext interceptorContext) throws InterceptorException {
        if (questionModel.getCode() == null || questionModel.getCode().isEmpty()) {
            questionModel.setCode(keyGenerator.generate().toString());
        }
    }

    @Required
    public void setKeyGenerator(KeyGenerator keyGenerator) {
        this.keyGenerator = keyGenerator;
    }
}
