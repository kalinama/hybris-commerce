package com.hybris.training.jobs;

import com.hybris.training.model.QuestionsUpdatesEmailProcessModel;
import com.hybris.training.model.QuestionsUpdatesEmailSendingCronJobModel;
import com.hybris.training.services.QuestionService;
import de.hybris.platform.catalog.constants.CatalogConstants;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.user.UserService;
import org.springframework.beans.factory.annotation.Required;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

public class QuestionsUpdatesEmailSendingJob extends AbstractJobPerformable<QuestionsUpdatesEmailSendingCronJobModel> {

    private final static String PROCESS_DEFINITION_NAME = "questionsUpdatesEmailProcess";

    private QuestionService questionService;
    private BusinessProcessService businessProcessService;
    private UserService userService;

    @Override
    public PerformResult perform(QuestionsUpdatesEmailSendingCronJobModel cronJobModel) {
        QuestionsUpdatesEmailProcessModel emailProcessModel = businessProcessService
                .createProcess(PROCESS_DEFINITION_NAME + System.currentTimeMillis(), PROCESS_DEFINITION_NAME);

        configureSession(cronJobModel);

        initProcess(cronJobModel, emailProcessModel);
        businessProcessService.startProcess(emailProcessModel);

        cronJobModel.setLastStartTime(cronJobModel.getStartTime());
        modelService.save(cronJobModel);
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }

    private void initProcess(QuestionsUpdatesEmailSendingCronJobModel cronJobModel,
                             QuestionsUpdatesEmailProcessModel emailProcessModel) {

        emailProcessModel.setCustomer((CustomerModel) userService
                .getUserForUID(cronJobModel.getRecipientEmailAddress()));

        Date lastEndTime = Optional.ofNullable(cronJobModel.getLastStartTime()).orElse(new Date());
        emailProcessModel.setQuestions(questionService.getQuestionsCreatedAfterDate(lastEndTime));

        emailProcessModel.setSite(cronJobModel.getBaseSite());
        emailProcessModel.setStore(cronJobModel.getStore());
        emailProcessModel.setLanguage(cronJobModel.getLanguage());
    }

    private void configureSession(QuestionsUpdatesEmailSendingCronJobModel cronJobModel) {
        SessionContext sessionContext = JaloSession.getCurrentSession().getSessionContext();

        sessionContext.setAttribute(CatalogConstants.SESSION_CATALOG_VERSIONS,
                Collections.singletonList(cronJobModel.getCatalogVersion()));
        sessionContext.setAttribute("disableRestrictions", false);
    }

    @Required
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Required
    public void setBusinessProcessService(BusinessProcessService businessProcessService) {
        this.businessProcessService = businessProcessService;
    }

    @Required
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
