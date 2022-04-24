package com.estockmarket.stock_market.stock_price;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/stock", produces = MediaType.APPLICATION_JSON_VALUE)
public class StockPriceController {

    private final StockPriceService stockPriceService;

    public StockPriceController(final StockPriceService stockPriceService) {
        this.stockPriceService = stockPriceService;
    }

    @GetMapping
    public ResponseEntity<List<StockPriceDTO>> getAllStockPrices() {
        return ResponseEntity.ok(stockPriceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockPriceDTO> getStockPrice(@PathVariable final Long id) {
        return ResponseEntity.ok(stockPriceService.get(id));
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<Long> createStockPrice(
            @RequestBody @Valid final StockPriceDTO stockPriceDTO) {
        return new ResponseEntity<>(stockPriceService.create(stockPriceDTO), HttpStatus.CREATED);
    }

	/*
	 * @PutMapping("/{id}") public ResponseEntity<Void>
	 * updateStockPrice(@PathVariable final Long id,
	 * 
	 * @RequestBody @Valid final StockPriceDTO stockPriceDTO) {
	 * stockPriceService.update(id, stockPriceDTO); return
	 * ResponseEntity.ok().build(); }
	 */

	/*
	 * @DeleteMapping("/{id}") public ResponseEntity<Void>
	 * deleteStockPrice(@PathVariable final Long id) { stockPriceService.delete(id);
	 * return ResponseEntity.noContent().build(); }
	 */

}
