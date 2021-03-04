/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package com.hybris.training.controllers;

import com.hybris.training.model.QuestionsCMSComponentModel;
import de.hybris.platform.acceleratorcms.model.components.CMSProductListComponentModel;

/**
 *
 */
public interface QuestionsaddonControllerConstants {

    /**
     * Class with action name constants
     */
    interface Actions {
        interface Cms {
            String _Prefix = "/view/";
            String _Suffix = "Controller";

            /**
             * CMS components that have specific handlers
             */
            String QuestionsCMSComponent = _Prefix + QuestionsCMSComponentModel._TYPECODE + _Suffix;
            String CMSProductListComponent = _Prefix + CMSProductListComponentModel._TYPECODE + _Suffix;

        }
    }
}
