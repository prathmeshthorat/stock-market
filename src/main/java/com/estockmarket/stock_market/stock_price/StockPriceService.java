package com.estockmarket.stock_market.stock_price;

import com.estockmarket.stock_market.company.Company;
import com.estockmarket.stock_market.company.CompanyRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class StockPriceService {

    private final StockPriceRepository stockPriceRepository;
    private final CompanyRepository companyRepository;

    public StockPriceService(final StockPriceRepository stockPriceRepository,
            final CompanyRepository companyRepository) {
        this.stockPriceRepository = stockPriceRepository;
        this.companyRepository = companyRepository;
    }

    public List<StockPriceDTO> findAll() {
        return stockPriceRepository.findAll()
                .stream()
                .map(stockPrice -> mapToDTO(stockPrice, new StockPriceDTO()))
                .collect(Collectors.toList());
    }

    public StockPriceDTO get(final Long id) {
        return stockPriceRepository.findById(id)
                .map(stockPrice -> mapToDTO(stockPrice, new StockPriceDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final StockPriceDTO stockPriceDTO) {
        final StockPrice stockPrice = new StockPrice();
        mapToEntity(stockPriceDTO, stockPrice);
        return stockPriceRepository.save(stockPrice).getId();
    }

    public void update(final Long id, final StockPriceDTO stockPriceDTO) {
        final StockPrice stockPrice = stockPriceRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(stockPriceDTO, stockPrice);
        stockPriceRepository.save(stockPrice);
    }

    public void delete(final Long id) {
        stockPriceRepository.deleteById(id);
    }

    private StockPriceDTO mapToDTO(final StockPrice stockPrice, final StockPriceDTO stockPriceDTO) {
        stockPriceDTO.setId(stockPrice.getId());
        stockPriceDTO.setCompanyCode(stockPrice.getCompanyCode());
        stockPriceDTO.setPrice(stockPrice.getPrice());
        stockPriceDTO.setCreatedBy(stockPrice.getCreatedBy());
        stockPriceDTO.setCompanyToStockPrice(stockPrice.getCompanyToStockPrice() == null ? null : stockPrice.getCompanyToStockPrice().getId());
        return stockPriceDTO;
    }

    private StockPrice mapToEntity(final StockPriceDTO stockPriceDTO, final StockPrice stockPrice) {
        stockPrice.setCompanyCode(stockPriceDTO.getCompanyCode());
        stockPrice.setPrice(stockPriceDTO.getPrice());
        stockPrice.setCreatedBy(stockPriceDTO.getCreatedBy());
        if (stockPriceDTO.getCompanyToStockPrice() != null && (stockPrice.getCompanyToStockPrice() == null || !stockPrice.getCompanyToStockPrice().getId().equals(stockPriceDTO.getCompanyToStockPrice()))) {
            final Company companyToStockPrice = companyRepository.findById(stockPriceDTO.getCompanyToStockPrice())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "companyToStockPrice not found"));
            stockPrice.setCompanyToStockPrice(companyToStockPrice);
        }
        return stockPrice;
    }

}
