package com.hybris.training.dao.impl;

import com.hybris.training.dao.QuestionDao;
import com.hybris.training.model.QuestionModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.springframework.beans.factory.annotation.Required;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DefaultQuestionDao implements QuestionDao {

    private final static String QUERY_FIND_QUESTIONS_BY_DATE = "SELECT {" + QuestionModel.PK + "} FROM {" + QuestionModel._TYPECODE
            + "} WHERE {" + QuestionModel.CREATIONTIME + "} > ?date";

    private FlexibleSearchService flexibleSearchService;

    @Override
    public List<QuestionModel> findQuestionsCreatedAfterDate(Date date) {
        Map<String, Object> params = Collections.singletonMap("date", date);
        SearchResult<QuestionModel> result = flexibleSearchService.search(QUERY_FIND_QUESTIONS_BY_DATE, params);
        return result.getResult();
    }

    @Required
    public void setFlexibleSearchService(FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }
}
