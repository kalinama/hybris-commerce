package com.hybris.training.setup;

import com.hybris.training.constants.QuestionsaddonConstants;
import de.hybris.platform.commerceservices.setup.AbstractSystemSetup;
import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.core.initialization.SystemSetupContext;
import de.hybris.platform.core.initialization.SystemSetupParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

@SystemSetup(extension = QuestionsaddonConstants.EXTENSIONNAME)
public class QuestionsaddonSystemSetup extends AbstractSystemSetup{

    private static final Logger LOG = LoggerFactory.getLogger(QuestionsaddonSystemSetup.class);

    @Override
    public List<SystemSetupParameter> getInitializationOptions() {
        return Collections.emptyList();
    }

    @SystemSetup(type = SystemSetup.Type.ESSENTIAL)
    public boolean createEssentialData(final SystemSetupContext context) {
        LOG.info("Starting custom essential data loading for the Questionsaddon...");
        importImpexFile(context,"/questionsaddon/import/stores/electronics/solr.impex");
        LOG.info("Custom essential data loading for the Questionsaddon completed.");
        return true;
    }

    @SystemSetup(type = SystemSetup.Type.PROJECT)
    public boolean createProjectData(final SystemSetupContext context) {
        LOG.info("Starting custom project data loading for the Questionsaddon...");
        LOG.info("Custom project data loading for the Questionsaddon completed.");
        return true;
    }

}
