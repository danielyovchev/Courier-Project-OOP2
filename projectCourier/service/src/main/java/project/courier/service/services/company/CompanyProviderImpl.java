package project.courier.service.services.company;

import project.courier.service.injector.CompanyRepositoryInjectorImpl;
import project.courier.service.injector.CourierRepositoryInjectorImpl;
import project.courier.service.injector.ShipmentRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CompanyRepositoryInjector;
import project.courier.service.injector.interfaces.CourierRepositoryInjector;
import project.courier.service.injector.interfaces.ShipmentRepositoryInjector;
import project.courier.service.model.CompanyTableModel;

import java.time.LocalDate;
import java.util.List;

/**
 * service that provides company
 */
public class CompanyProviderImpl implements CompanyProvider {
    private final CompanyRepositoryInjector companyRepositoryInjector = new CompanyRepositoryInjectorImpl();
    private final ShipmentRepositoryInjector shipmentRepositoryInjector = new ShipmentRepositoryInjectorImpl();
    @Override
    public List<CompanyTableModel> getAllCompanies() {
        return companyRepositoryInjector.getCompanyRepository().findAll().stream().
                map(company -> CompanyTableModel.builder().companyId(company.getId()).companyName(company.getName()).shipmentCount(1)
                        .build()).toList();
    }

    @Override
    public List<CompanyTableModel> getDeliveriesByCompany() {
        return companyRepositoryInjector.getCompanyRepository().findAll().stream()
                .map(company -> CompanyTableModel.builder()
                        .companyId(company.getId())
                        .companyName(company.getName())
                        .shipmentCount(shipmentRepositoryInjector.getShipmentRepository()
                                .findAllByCompany(company.getId()).size())
                        .build())
                .toList();
    }

    @Override
    public List<CompanyTableModel> getDeliveriesByCompanyBetweenDates(LocalDate date1, LocalDate date2) {
        return companyRepositoryInjector.getCompanyRepository().findAll().stream()
                .map(company -> CompanyTableModel.builder()
                        .companyId(company.getId())
                        .companyName(company.getName())
                        .shipmentCount(shipmentRepositoryInjector.getShipmentRepository()
                                .findAllByCompany(company.getId())
                                .stream()
                                .filter(s -> date1.isBefore(s.getDateSent()))
                                .filter(s -> date2.isAfter(s.getDateReceived()))
                                .toList()
                                .size())
                        .build())
                .toList();
    }

    @Override
    public long getCurrentCompanyIdByName(String name) {
        return companyRepositoryInjector.getCompanyRepository().findByName(name).get().getId();
    }

    @Override
    public List<String> getNames() {
        return companyRepositoryInjector.getCompanyRepository().findAll().stream().map(c -> c.getName()).toList();
    }

    @Override
    public String getCompanyFromCourier(String username) {
        final CourierRepositoryInjector courierRepositoryInjector = new CourierRepositoryInjectorImpl();
        return courierRepositoryInjector.getCourierRepository().findByUsername(username)
                .map(el -> companyRepositoryInjector.getCompanyRepository().findById(el.getCompanyId()))
                .map(c -> c.get().getName()).get();
    }
}
