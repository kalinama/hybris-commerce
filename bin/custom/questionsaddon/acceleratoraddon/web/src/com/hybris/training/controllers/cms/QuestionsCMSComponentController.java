package com.hybris.training.controllers.cms;

import com.hybris.training.controllers.QuestionsaddonControllerConstants;
import com.hybris.training.model.QuestionsCMSComponentModel;
import de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller("QuestionsCMSComponentController")
@RequestMapping(value = QuestionsaddonControllerConstants.Actions.Cms.CustomOffersComponent)
public class QuestionsCMSComponentController extends AbstractCMSAddOnComponentController<QuestionsCMSComponentModel> {

    @Override
    protected void fillModel(HttpServletRequest request, Model model, QuestionsCMSComponentModel component) {
        model.addAttribute("fontSize", component.getFontSize());
        model.addAttribute("questionsNumber", component.getNumberOfQuestionsToShow());
    }

}
