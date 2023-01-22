package project.courier.service.interfaces;

import project.courier.service.model.CourierModel;

import java.util.List;

public interface CourierProvider
{
    List<CourierModel> getAllCouriers();

}
