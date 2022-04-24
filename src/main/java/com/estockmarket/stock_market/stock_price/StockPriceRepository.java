package com.estockmarket.stock_market.stock_price;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface StockPriceRepository extends MongoRepository<StockPrice, Long> {
}
