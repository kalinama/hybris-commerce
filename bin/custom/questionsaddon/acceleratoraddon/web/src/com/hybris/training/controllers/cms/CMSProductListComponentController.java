package com.hybris.training.controllers.cms;

import com.hybris.training.constants.QuestionsaddonConstants;
import com.hybris.training.controllers.QuestionsaddonControllerConstants;
import de.hybris.platform.addonsupport.controllers.cms.GenericCMSAddOnComponentController;
import de.hybris.platform.cms2.model.contents.components.AbstractCMSComponentModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("CMSProductListComponentController")
@RequestMapping(value = QuestionsaddonControllerConstants.Actions.Cms.CMSProductListComponent)
public class CMSProductListComponentController extends GenericCMSAddOnComponentController {

    @Override
    protected String getView(AbstractCMSComponentModel component) {
        return "addon:" + "/" + QuestionsaddonConstants.EXTENSIONNAME + "/" + getCmsComponentFolder() + "/"
                + getViewResourceName(component);
    }
}
