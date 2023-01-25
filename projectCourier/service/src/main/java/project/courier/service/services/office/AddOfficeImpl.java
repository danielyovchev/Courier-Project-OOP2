package project.courier.service.services.office;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project.courier.data.entity.Office;
import project.courier.service.injector.CompanyRepositoryInjectorImpl;
import project.courier.service.injector.OfficeRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CompanyRepositoryInjector;
import project.courier.service.injector.interfaces.OfficeRepositoryInjector;
import project.courier.service.model.OfficeModel;

/**
 * adds new office to db
 */
public class AddOfficeImpl implements AddOffice {
    private final OfficeRepositoryInjector officeInjector = new OfficeRepositoryInjectorImpl();
    private final CompanyRepositoryInjector companyInjector = new CompanyRepositoryInjectorImpl();
    private static final Logger logger = LogManager.getLogger(AddOfficeImpl.class);
    @Override
    public void addOffice(OfficeModel officeModel) {
        final Long companyId = companyInjector.getCompanyRepository().findByName(officeModel.getCompany()).get().getId();
        Office office = new Office();
        office.setCity(officeModel.getCity());
        office.setCompanyId(companyId);
        officeInjector.getOfficeRepository().save(office);
        logger.info("Office {} saved", officeModel.getCity());
    }
}
