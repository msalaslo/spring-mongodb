package com.msl.mongo.domain.promocion;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.BulkOperations.BulkMode;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.mongodb.BulkWriteResult;

@Component
public class PromocionRepositoryCustomImpl {//implements PromocionRepositoryCustom{
	
	Logger logger = LoggerFactory.getLogger(PromocionRepositoryLoaderTests.class);

	@Autowired
	MongoTemplate mongoTemplate;
	
	public CompletableFuture<Integer> save(List<Promocion> promociones) {
		BulkOperations bulk = mongoTemplate.bulkOps(BulkMode.UNORDERED, Promocion.class);

		logger.debug("Antes de bulk insert");
		bulk.insert(promociones);

		logger.debug("Antes de executebulk");
		BulkWriteResult result = bulk.execute();
		logger.debug("despues de execute bulk");
		return CompletableFuture.completedFuture(result.getInsertedCount());
		
	}

}
