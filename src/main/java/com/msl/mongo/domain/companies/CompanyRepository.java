package com.msl.mongo.domain.companies;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company, String> {

    public Company findByName(String name);

}
