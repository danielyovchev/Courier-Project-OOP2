package project.courier.service.services.company;

import project.courier.service.model.CompanyTableModel;

import java.time.LocalDate;
import java.util.List;

public interface CompanyProvider
{
  List<CompanyTableModel> getAllCompanies();
  List<CompanyTableModel> getDeliveriesByCompany();
  List<CompanyTableModel> getDeliveriesByCompanyBetweenDates(LocalDate date1, LocalDate date2);
  long getCurrentCompanyIdByName(String name);
  List<String> getNames();
  String getCompanyFromCourier(String username);
}
