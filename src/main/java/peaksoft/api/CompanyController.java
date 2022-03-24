package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.CompanyRequest;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.model.Company;
import peaksoft.service.CompanyService;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public CompanyResponse saveCompany(@RequestBody  CompanyRequest companyRequest) {
        return companyService.saveCompany(companyRequest);
    }

    @PatchMapping("/update/{id}")
    public CompanyResponse updateCompany(@PathVariable Long id, @RequestBody CompanyRequest companyRequest) {
        return companyService.updateCompany(id, companyRequest);
    }

    @GetMapping("/get/{id}")
    public Optional<Company> getCompanyById(@PathVariable Long id) {
        return companyService.findById(id);
    }

    @GetMapping()
    public List<CompanyResponse> getAllCompanies(List<Company>companyList) {
        return companyService.getCompanies(companyList);
    }

    @DeleteMapping("{id}")
        public void deleteCompany(@PathVariable Long id){
           companyService.deleteCompany(id);
        }

    }

