package project.courier.service;

import project.courier.service.injector.CourierRepositoryInjectorImpl;
import project.courier.service.injector.OfficeRepositoryInjectorImpl;
import project.courier.service.injector.ShipmentRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CourierRepositoryInjector;
import project.courier.service.injector.interfaces.OfficeRepositoryInjector;
import project.courier.service.injector.interfaces.ShipmentRepositoryInjector;
import project.courier.service.interfaces.ShipmentProvider;
import project.courier.service.model.ShipmentModel;
import project.courier.service.model.ShipmentTableModel;

import java.time.LocalDate;
import java.util.List;

/**
 * provides list of shipments based on different criteria
 */
public class ShipmentProviderImpl implements ShipmentProvider {
    final ShipmentRepositoryInjector shipmentRepositoryInjector = new ShipmentRepositoryInjectorImpl();
    final OfficeRepositoryInjector officeRepositoryInjector = new OfficeRepositoryInjectorImpl();
    final CourierRepositoryInjector courierRepositoryInjector = new CourierRepositoryInjectorImpl();
    @Override
    public List<ShipmentModel> getShipmentsBetweenDates(LocalDate date1, LocalDate date2) {
        return shipmentRepositoryInjector.getShipmentRepository().findAllBetweenDates(date1, date2).stream()
                .map(s -> ShipmentModel.builder()
                        .type(s.getCategory().toString())
                        .dateSent(s.getDateSent())
                        .email("")
                        .office("")
                        .phone("")
                        .courierUsername("")
                        .city(s.getDestination())
                        .firstName("")
                        .lastName("")
                        .build())
                .toList();
    }

    @Override
    public ShipmentModel getShipment(Long id) {
        return shipmentRepositoryInjector.getShipmentRepository().findById(id).map(s -> ShipmentModel.builder()
                .type(s.getCategory().toString())
                .dateSent(s.getDateSent())
                .email("")
                .office("")
                .phone("")
                .courierUsername("")
                .city(s.getDestination())
                .firstName("")
                .lastName("")
                .build())
                .get();
    }

    @Override
    public List<ShipmentTableModel> getCustomerShipments(Long id) {
        return shipmentRepositoryInjector.getShipmentRepository().findAllByCustomer(id).stream()
                .map(s -> ShipmentTableModel.builder()
                        .shipmentId(s.getId())
                        .category(s.getCategory().toString())
                        .dateSent(s.getDateSent())
                        .office(officeRepositoryInjector.getOfficeRepository().findById(s.getOfficeId()).toString())
                        .destination(s.getDestination())
                        .price(s.getPrice())
                        .status(s.getStatus().toString())
                        .build()).toList();
    }

    @Override
    public List<ShipmentTableModel> getCourierShipments(Long id) {
        return shipmentRepositoryInjector.getShipmentRepository().findAllByCourier(id).stream()
                .map(s -> ShipmentTableModel.builder()
                        .shipmentId(s.getId())
                        .category(s.getCategory().toString())
                        .dateSent(s.getDateSent())
                        .office(officeRepositoryInjector.getOfficeRepository().findById(s.getOfficeId()).toString())
                        .destination(s.getDestination())
                        .price(s.getPrice())
                        .status(s.getStatus().toString())
                        .build()).toList();
    }

    @Override
    public List<ShipmentTableModel> getCompanyShipments() {
        return shipmentRepositoryInjector.getShipmentRepository().findAll().stream()
                .map(s -> ShipmentTableModel.builder()
                        .shipmentId(s.getId())
                        .category(s.getCategory().toString())
                        .dateSent(s.getDateSent())
                        .office(officeRepositoryInjector.getOfficeRepository().findById(s.getOfficeId()).toString())
                        .destination(s.getDestination())
                        .price(s.getPrice())
                        .status(s.getStatus().toString())
                        .companyId(courierRepositoryInjector.getCourierRepository().findById(s.getCourierId()).get().getCompanyId())
                        .build()).toList();
    }
}
