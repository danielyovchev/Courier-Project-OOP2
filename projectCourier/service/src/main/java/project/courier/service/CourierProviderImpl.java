package project.courier.service;

import project.courier.service.injector.CompanyRepositoryInjectorImpl;
import project.courier.service.injector.CourierRepositoryInjectorImpl;
import project.courier.service.injector.ShipmentRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CompanyRepositoryInjector;
import project.courier.service.injector.interfaces.CourierRepositoryInjector;
import project.courier.service.injector.interfaces.ShipmentRepositoryInjector;
import project.courier.service.interfaces.CourierProvider;
import project.courier.service.model.CourierTableModel;

import java.time.LocalDate;
import java.util.List;

public class CourierProviderImpl implements CourierProvider {
    private final CourierRepositoryInjector courierRepositoryInjector = new CourierRepositoryInjectorImpl();
    private final ShipmentRepositoryInjector shipmentRepositoryInjector = new ShipmentRepositoryInjectorImpl();
    private final CompanyRepositoryInjector companyRepositoryInjector = new CompanyRepositoryInjectorImpl();

    @Override
    public List<CourierTableModel> getCouriersForCompany(String company) {
        final Long companyId = companyRepositoryInjector.getCompanyRepository().findByName(company).get().getId();
        return courierRepositoryInjector.getCourierRepository().findAllByCompany(companyId).stream()
                .map(c -> CourierTableModel.builder()
                        .id(c.getId())
                        .email(c.getEmail())
                        .companyName(company)
                        .username(c.getUsername())
                        .courierName(c.getFirstName()+" "+c.getLastName())
                        .shipmentsCount(shipmentRepositoryInjector.getShipmentRepository()
                                .findAllByCourier(c.getId()).size()).build())
                .toList();
    }

    @Override
    public List<CourierTableModel> getCouriersForCompanyBetweenDates(String company, LocalDate date1, LocalDate date2) {
        final Long companyId = companyRepositoryInjector.getCompanyRepository().findByName(company).get().getId();
        return courierRepositoryInjector.getCourierRepository().findAllByCompany(companyId).stream()
                .map(c -> CourierTableModel.builder()
                        .id(c.getId())
                        .email(c.getEmail())
                        .companyName(company)
                        .username(c.getUsername())
                        .courierName(c.getFirstName()+" "+c.getLastName())
                        .shipmentsCount(shipmentRepositoryInjector.getShipmentRepository()
                                .findAllByCourier(c.getId()).stream()
                                .filter(s -> date1.isBefore(s.getDateSent()))
                                .filter(s -> date2.isAfter(s.getDateReceived()))
                                .toList().size())
                        .build())
                .toList();
    }
}
