package com.hybris.training.setup;

import de.hybris.platform.addonsupport.setup.impl.DefaultAddonSampleDataImportService;
import de.hybris.platform.core.initialization.SystemSetupContext;

public class QuestionsaddonSampleDataImportService extends DefaultAddonSampleDataImportService {

    private static final String PRODUCT_CATALOGS_URL = "/productCatalogs/";

    @Override
    protected void importProductCatalog(SystemSetupContext context, String importRoot, String catalogName) {
        super.importProductCatalog(context, importRoot, catalogName);
        importImpexFile(context, importRoot + PRODUCT_CATALOGS_URL + catalogName + "ProductCatalog/questions.impex",
                false);
    }
}
