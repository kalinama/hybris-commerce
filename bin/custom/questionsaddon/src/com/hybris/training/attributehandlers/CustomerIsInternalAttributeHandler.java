package com.hybris.training.attributehandlers;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.attribute.AbstractDynamicAttributeHandler;

public class CustomerIsInternalAttributeHandler extends AbstractDynamicAttributeHandler<Boolean, CustomerModel> {

    @Override
    public Boolean get(CustomerModel model) {
        String email = model.getUid();
        return email != null
                && (email.endsWith("hybris.de") || email.endsWith("hybris.com"));
    }

}
