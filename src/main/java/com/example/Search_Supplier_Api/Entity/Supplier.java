package com.example.Search_Supplier_Api.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "suppliers")
public class Supplier {
    @Id
    private String supplierId;
    private String companyName;
    private String website;
    private String location;
    private String natureOfBusiness; // small_scale, medium_scale, large_scale
    private String manufacturingProcess; // moulding, 3d_printing, casting, coating

    public Supplier(String companyName, String website, String location, String natureOfBusiness, String manufacturingProcess) {
        this.companyName = companyName;
        this.website = website;
        this.location = location;
        this.natureOfBusiness = natureOfBusiness;
        this.manufacturingProcess = manufacturingProcess;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setNatureOfBusiness(String natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public void setManufacturingProcess(String manufacturingProcess) {
        this.manufacturingProcess = manufacturingProcess;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getWebsite() {
        return website;
    }

    public String getLocation() {
        return location;
    }

    public String getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public String getManufacturingProcess() {
        return manufacturingProcess;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId='" + supplierId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", website='" + website + '\'' +
                ", location='" + location + '\'' +
                ", natureOfBusiness='" + natureOfBusiness + '\'' +
                ", manufacturingProcess='" + manufacturingProcess + '\'' +
                '}';
    }
}
