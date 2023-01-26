package project.courier.service.services.courier;

import project.courier.service.model.CourierTableModel;

import java.time.LocalDate;
import java.util.List;

public interface CourierProvider {
    List<CourierTableModel> getCouriersForCompany(String company);
    List<CourierTableModel> getCouriersForCompanyBetweenDates(String company, LocalDate date1, LocalDate date2);
}
