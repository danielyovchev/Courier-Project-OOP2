package project.courier.service.interfaces;

import java.util.List;

public interface OfficeProvider {
    List<String> getAllOffices();
    List<String> getOfficesByCity(String city);
}
