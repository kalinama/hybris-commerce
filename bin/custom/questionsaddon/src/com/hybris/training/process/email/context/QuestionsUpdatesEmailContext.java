package com.hybris.training.process.email.context;

import com.hybris.training.model.QuestionModel;
import com.hybris.training.model.QuestionsUpdatesEmailProcessModel;
import de.hybris.platform.acceleratorservices.model.cms2.pages.EmailPageModel;
import de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class QuestionsUpdatesEmailContext extends AbstractEmailContext<QuestionsUpdatesEmailProcessModel> {

   private List<ProductData> products;
   private Converter<Entry<ProductModel, List<QuestionModel>>, ProductData> entryToProductDataConverter;

   @Override
   public void init(QuestionsUpdatesEmailProcessModel businessProcessModel, EmailPageModel emailPageModel) {
      super.init(businessProcessModel, emailPageModel);
      Map<ProductModel, List<QuestionModel>> questionsPerProduct = CollectionUtils
              .emptyIfNull(businessProcessModel.getQuestions())
              .stream()
              .filter(questionModel -> questionModel.getProduct() != null)
              .collect(Collectors.groupingBy(QuestionModel::getProduct));
      products = entryToProductDataConverter.convertAll(questionsPerProduct.entrySet());
   }

   @Override
   protected BaseSiteModel getSite(QuestionsUpdatesEmailProcessModel businessProcessModel) {
      return businessProcessModel.getSite();
   }

   @Override
   protected CustomerModel getCustomer(QuestionsUpdatesEmailProcessModel businessProcessModel) {
      return businessProcessModel.getCustomer();
   }

   @Override
   protected LanguageModel getEmailLanguage(QuestionsUpdatesEmailProcessModel businessProcessModel) {
      return null;
   }

   @Required
   public void setEntryToProductDataConverter(Converter<Entry<ProductModel, List<QuestionModel>>,
           ProductData> entryToProductDataConverter) {
      this.entryToProductDataConverter = entryToProductDataConverter;
   }

   public List<ProductData> getProducts() {
      return products;
   }

}
