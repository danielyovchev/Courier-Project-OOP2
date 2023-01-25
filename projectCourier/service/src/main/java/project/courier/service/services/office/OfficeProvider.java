package project.courier.service.services.office;

import java.util.List;

public interface OfficeProvider {
    List<String> getAllOffices(String username);
    List<String> getOfficesByCity(String city);
}
