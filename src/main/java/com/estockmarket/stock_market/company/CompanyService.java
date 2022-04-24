package com.estockmarket.stock_market.company;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(final CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<CompanyDTO> findAll() {
        return companyRepository.findAll()
                .stream()
                .map(company -> mapToDTO(company, new CompanyDTO()))
                .collect(Collectors.toList());
    }

    public CompanyDTO get(final Long id) {
        return companyRepository.findById(id)
                .map(company -> mapToDTO(company, new CompanyDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final CompanyDTO companyDTO) {
        final Company company = new Company();
        mapToEntity(companyDTO, company);
        return companyRepository.save(company).getId();
    }

    public void update(final Long id, final CompanyDTO companyDTO) {
        final Company company = companyRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(companyDTO, company);
        companyRepository.save(company);
    }

    public void delete(final Long id) {
        companyRepository.deleteById(id);
    }

    private CompanyDTO mapToDTO(final Company company, final CompanyDTO companyDTO) {
        companyDTO.setId(company.getId());
        companyDTO.setCompanyCode(company.getCompanyCode());
        companyDTO.setCompanyName(company.getCompanyName());
        companyDTO.setCompanyCEO(company.getCompanyCEO());
        companyDTO.setCompanyTurnover(company.getCompanyTurnover());
        companyDTO.setCompanyWebsite(company.getCompanyWebsite());
        companyDTO.setStockExchange(company.getStockExchange());
        companyDTO.setCreatedBy(company.getCreatedBy());
        companyDTO.setModifiedBy(company.getModifiedBy());
        return companyDTO;
    }

    private Company mapToEntity(final CompanyDTO companyDTO, final Company company) {
        company.setCompanyCode(companyDTO.getCompanyCode());
        company.setCompanyName(companyDTO.getCompanyName());
        company.setCompanyCEO(companyDTO.getCompanyCEO());
        company.setCompanyTurnover(companyDTO.getCompanyTurnover());
        company.setCompanyWebsite(companyDTO.getCompanyWebsite());
        company.setStockExchange(companyDTO.getStockExchange());
        company.setCreatedBy(companyDTO.getCreatedBy());
        company.setModifiedBy(companyDTO.getModifiedBy());
        return company;
    }

}
