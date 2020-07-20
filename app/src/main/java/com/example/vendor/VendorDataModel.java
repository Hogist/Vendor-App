package com.example.vendor;

public class VendorDataModel {

    String BreakfastID;
    String VendorFullName;
    String CompanyName;
    String EnterpriseID;
    String EnterpriseName;
    String MenuId;

    public VendorDataModel(String vendorID, String vendorFullName, String companyName, String enterpriseID, String enterpriseName, String menuId) {
        BreakfastID = vendorID;
        VendorFullName = vendorFullName;
        CompanyName = companyName;
        EnterpriseID = enterpriseID;
        EnterpriseName = enterpriseName;
        MenuId = menuId;
    }

    public String getVendorID() {
        return BreakfastID;
    }

    public void setVendorID(String vendorID) {
        BreakfastID = vendorID;
    }

    public String getVendorFullName() {
        return VendorFullName;
    }

    public void setVendorFullName(String vendorFullName) {
        VendorFullName = vendorFullName;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getEnterpriseID() {
        return EnterpriseID;
    }

    public void setEnterpriseID(String enterpriseID) {
        EnterpriseID = enterpriseID;
    }

    public String getEnterpriseName() {
        return EnterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        EnterpriseName = enterpriseName;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

}
