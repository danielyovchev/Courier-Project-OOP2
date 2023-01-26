package project.courier.service.services.company;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project.courier.data.entity.Company;
import project.courier.service.exceptions.CompanyExistsException;
import project.courier.service.injector.CompanyRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CompanyRepositoryInjector;
import project.courier.service.model.CompanyModel;

/**
 * service that registers company
 */
public class CompanyRegisterImpl implements CompanyRegister {
    private final CompanyRepositoryInjector injector = new CompanyRepositoryInjectorImpl();
    private static final Logger logger = LogManager.getLogger(CompanyRegisterImpl.class);
    @Override
    public void addCompany(CompanyModel companyModel) {
        if(injector.getCompanyRepository().existsByBulstatAndName(companyModel.getName(), companyModel.getBulstat())){
            throw new CompanyExistsException();
        }
        Company company = new Company();
        company.setName(companyModel.getName());
        company.setBulstat(companyModel.getBulstat());
        injector.getCompanyRepository().save(company);
        logger.info("Company {} saved", companyModel.getName());
    }
}
