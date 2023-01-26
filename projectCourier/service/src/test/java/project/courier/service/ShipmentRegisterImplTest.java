package project.courier.service;

import org.junit.Test;
import project.courier.data.entity.Shipment;
import project.courier.data.entity.enums.ShipmentCategory;
import project.courier.service.exceptions.CustomerNotFoundException;
import project.courier.service.model.ShipmentModel;
import project.courier.service.services.shipment.ShipmentRegister;
import project.courier.service.services.shipment.ShipmentRegisterImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShipmentRegisterImplTest {
    final ShipmentRegister shipmentRegister = new ShipmentRegisterImpl();
    @Test(expected = CustomerNotFoundException.class)
    public void registerShipmentNoCustomerFound() {
        final ShipmentModel model = ShipmentModel.builder().courierUsername("m.minchev").build();
        shipmentRegister.registerShipment(model);
    }

    @Test
    public void regShipment(){
        final ShipmentModel model = ShipmentModel.builder().type("package").build();
        assertEquals(4.50, getResult(model).getPrice().doubleValue());
    }

    Shipment getResult(ShipmentModel model){
        double price = 0;
        if(model.getType().equalsIgnoreCase("ENVELOPE")){
            price= 2.50;
        }
        else if(model.getType().equalsIgnoreCase("PARCEL")){
            price=3.50;
        }
        else if(model.getType().equalsIgnoreCase("PACKAGE")){
            price=4.50;
        }
        else if(model.getType().equalsIgnoreCase("CARGO")){
            price=10.50;
        }
        return Shipment.builder()
                .category(ShipmentCategory.valueOf(model.getType().toUpperCase()))
                .price(price)
                .build();
    }
}