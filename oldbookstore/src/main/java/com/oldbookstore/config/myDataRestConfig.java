package com.oldbookstore.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import com.oldbookstore.entity.Book;
import com.oldbookstore.entity.Category;
import com.oldbookstore.entity.Order;
import com.oldbookstore.entity.OrderItem;
import com.oldbookstore.entity.Review;
import com.oldbookstore.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;

@Configuration
public class myDataRestConfig implements RepositoryRestConfigurer {
	
	private EntityManager entitymanager;
	
	@Autowired
	public myDataRestConfig(EntityManager theEntityManager) {
		entitymanager = theEntityManager;
	}
	
	

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
		HttpMethod[] theUnsupportedActions = { HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.POST };
		config.getExposureConfiguration().forDomainType(User.class)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

		config.getExposureConfiguration().forDomainType(Book.class)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

		config.getExposureConfiguration().forDomainType(Category.class)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

		config.getExposureConfiguration().forDomainType(Review.class)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

		config.getExposureConfiguration().forDomainType(Order.class)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

		config.getExposureConfiguration().forDomainType(OrderItem.class)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
	
		exposeIds(config);
	}



	private void exposeIds(RepositoryRestConfiguration config) {
		Set<EntityType<?>> entities =  entitymanager.getMetamodel().getEntities();
		
		List<Class> entityClass = new ArrayList<>();
		
		for (EntityType tempEntityType : entities) {
			entityClass.add(tempEntityType.getJavaType());	
		}
		
		Class[] domainType = entityClass.toArray(new Class[0]);
		config.exposeIdsFor(domainType);
		
	}

}
