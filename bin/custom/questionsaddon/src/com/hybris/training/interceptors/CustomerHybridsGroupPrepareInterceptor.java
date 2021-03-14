package com.hybris.training.interceptors;

import de.hybris.platform.core.model.security.PrincipalGroupModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import de.hybris.platform.servicelayer.user.daos.UserGroupDao;
import org.springframework.beans.factory.annotation.Required;

import java.util.HashSet;
import java.util.Set;

public class CustomerHybridsGroupPrepareInterceptor implements PrepareInterceptor<CustomerModel> {

    private final static String HYBRIDS_GROUP_UID = "hybrids";

    private UserGroupDao userGroupDao;

    @Override
    public void onPrepare(CustomerModel customerModel, InterceptorContext interceptorContext) throws InterceptorException {
        UserGroupModel hybridsGroupModel = userGroupDao.findUserGroupByUid(HYBRIDS_GROUP_UID);
        if (customerModel.getIsInternal()) {
            if (!customerModel.getGroups().contains(hybridsGroupModel)) {
                Set<PrincipalGroupModel> customerGroups = new HashSet<>(customerModel.getGroups());
                customerGroups.add(hybridsGroupModel);
                customerModel.setGroups(customerGroups);
            }
        } else {
            if (customerModel.getGroups().contains(hybridsGroupModel)) {
                Set<PrincipalGroupModel> customerGroups = new HashSet<>(customerModel.getGroups());
                customerGroups.remove(hybridsGroupModel);
                customerModel.setGroups(customerGroups);
            }
        }
    }

    @Required
    public void setUserGroupDao(UserGroupDao userGroupDao) {
        this.userGroupDao = userGroupDao;
    }
}
