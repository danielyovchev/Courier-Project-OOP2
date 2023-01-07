package project.courier.service;

import project.courier.service.injector.ShipmentRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.ShipmentRepositoryInjector;
import project.courier.service.interfaces.ShipmentProvider;
import project.courier.service.model.ShipmentModel;

import java.time.LocalDate;
import java.util.List;

public class ShipmentProviderImpl implements ShipmentProvider {
    final ShipmentRepositoryInjector shipmentRepositoryInjector = new ShipmentRepositoryInjectorImpl();
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
    public List<ShipmentModel> getCustomerShipments(Long id) {
        return shipmentRepositoryInjector.getShipmentRepository().findAllByCustomer(id).stream()
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
                        .build()).toList();
    }
}
