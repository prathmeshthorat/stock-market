package com.estockmarket.stock_market.company;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface CompanyRepository extends MongoRepository<Company, Long> {
}
