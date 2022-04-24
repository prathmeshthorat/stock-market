package com.estockmarket.stock_market.company;

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
@RequestMapping(value = "/company", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(final CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<CompanyDTO>> getAllCompanys() {
        return ResponseEntity.ok(companyService.findAll());
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<CompanyDTO> getCompany(@PathVariable final Long id) {
        return ResponseEntity.ok(companyService.get(id));
    }

    @PostMapping("/register")
    public ResponseEntity<Long> createCompany(@RequestBody @Valid final CompanyDTO companyDTO) {
        return new ResponseEntity<>(companyService.create(companyDTO), HttpStatus.CREATED);
    }

	/*
	 * @PutMapping("/{id}") public ResponseEntity<Void> updateCompany(@PathVariable
	 * final Long id,
	 * 
	 * @RequestBody @Valid final CompanyDTO companyDTO) { companyService.update(id,
	 * companyDTO); return ResponseEntity.ok().build(); }
	 */

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable final Long id) {
        companyService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
