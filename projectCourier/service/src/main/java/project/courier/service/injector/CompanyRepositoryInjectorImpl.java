package project.courier.service.injector;

import project.courier.data.repository.CompanyRepository;
import project.courier.data.repository.CompanyRepositoryImpl;
import project.courier.data.util.DBUtils;
import project.courier.service.injector.interfaces.CompanyRepositoryInjector;

public class CompanyRepositoryInjectorImpl implements CompanyRepositoryInjector {
    @Override
    public CompanyRepository getCompanyRepository() {
        return new CompanyRepositoryImpl(new DBUtils());
    }
}
