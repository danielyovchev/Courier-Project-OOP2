package project.courier.service.interfaces;

import java.util.List;

public interface OfficeProvider {
    List<String> getAllOffices(String username);
    List<String> getOfficesByCity(String city);
}
