package project.courier.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project.courier.data.entity.Company;
import project.courier.service.injector.CompanyRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CompanyRepositoryInjector;
import project.courier.service.interfaces.CompanyRegister;
import project.courier.service.model.CompanyModel;

public class CompanyRegisterImpl implements CompanyRegister {
    final CompanyRepositoryInjector injector = new CompanyRepositoryInjectorImpl();
    private static final Logger logger = LogManager.getLogger(CompanyRegisterImpl.class);
    @Override
    public void addCompany(CompanyModel companyModel) {
        Company company = new Company();
        company.setName(companyModel.getName());
        company.setBulstat(companyModel.getBulstat());
        injector.getCompanyRepository().save(company);
        logger.info("Company {} saved", companyModel.getName());
    }
}
