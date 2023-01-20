package project.courier.service.interfaces;

import project.courier.service.model.CompanyTableModel;

import java.util.List;

public interface CompanyProvider
{
  List<CompanyTableModel> getAllCompanies();
  long getCurrentCompanyIdByName(String name);
  List<String> getNames();
  String getCompanyFromCourier(String username);
}
