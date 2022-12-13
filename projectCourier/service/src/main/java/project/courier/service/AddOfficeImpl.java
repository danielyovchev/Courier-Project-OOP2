package project.courier.service;

import project.courier.data.entity.Office;
import project.courier.service.injector.CompanyRepositoryInjectorImpl;
import project.courier.service.injector.OfficeRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CompanyRepositoryInjector;
import project.courier.service.injector.interfaces.OfficeRepositoryInjector;
import project.courier.service.interfaces.AddOffice;
import project.courier.service.model.OfficeModel;

public class AddOfficeImpl implements AddOffice {
    @Override
    public void addOffice(OfficeModel officeModel) {
        final OfficeRepositoryInjector officeInjector = new OfficeRepositoryInjectorImpl();
        final CompanyRepositoryInjector companyInjector = new CompanyRepositoryInjectorImpl();
        final Long companyId = companyInjector.getCompanyRepository().findByName(officeModel.getCompany()).get().getId();
        Office office = new Office();
        office.setCity(officeModel.getCity());
        office.setCompanyId(companyId);
        officeInjector.getOfficeRepository().save(office);
    }
}
