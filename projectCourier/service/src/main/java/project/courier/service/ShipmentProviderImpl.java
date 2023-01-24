package project.courier.service;

import project.courier.service.injector.OfficeRepositoryInjectorImpl;
import project.courier.service.injector.ShipmentRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.OfficeRepositoryInjector;
import project.courier.service.injector.interfaces.ShipmentRepositoryInjector;
import project.courier.service.interfaces.ShipmentProvider;
import project.courier.service.model.ShipmentTableModel;

import java.time.LocalDate;
import java.util.List;

/**
 * provides list of shipments based on different criteria
 */
public class ShipmentProviderImpl implements ShipmentProvider {
    private final ShipmentRepositoryInjector shipmentRepositoryInjector = new ShipmentRepositoryInjectorImpl();
    private final OfficeRepositoryInjector officeRepositoryInjector = new OfficeRepositoryInjectorImpl();
    @Override
    public List<ShipmentTableModel> getShipmentsBetweenDates(Long id, LocalDate date1, LocalDate date2) {
        return shipmentRepositoryInjector.getShipmentRepository().findAllByCustomer(id).stream()
                .filter(s -> date1.isBefore(s.getDateSent()))
                .filter(s -> date2.isAfter(s.getDateReceived()))
                .map(s -> ShipmentTableModel.builder()
                        .shipmentId(s.getId())
                        .status(s.getStatus().toString())
                        .build())
                .toList();
    }

    @Override
    public ShipmentTableModel getShipment(Long id) {
        return shipmentRepositoryInjector.getShipmentRepository().findById(id).map(s -> ShipmentTableModel.builder()
                .shipmentId(s.getId())
                .category(s.getCategory().toString())
                .dateSent(s.getDateSent())
                .office(officeRepositoryInjector.getOfficeRepository().findById(s.getOfficeId()).toString())
                .destination(s.getDestination())
                .price(s.getPrice())
                .status(s.getStatus().toString())
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
                        .office(officeRepositoryInjector.getOfficeRepository().findById(s.getOfficeId()).get().getCity())
                        .destination(s.getDestination())
                        .price(s.getPrice())
                        .status(s.getStatus().toString())
                        .build()).toList();
    }
}
