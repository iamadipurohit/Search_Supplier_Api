package com.example.Search_Supplier_Api.Services;

import com.example.Search_Supplier_Api.Entity.Supplier;
import com.example.Search_Supplier_Api.Repo.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
    private static final int DEFAULT_PAGE_SIZE = 10;

    @Autowired
    private SupplierRepository supplierRepository;

    public Page<Supplier> searchSuppliers(String location, String natureOfBusiness, String process, Integer page, Integer size) {
        int pageNumber = (page == null || page < 0) ? 0 : page;
        int pageSize = (size == null || size <= 0) ? DEFAULT_PAGE_SIZE : size;

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        try {
            return supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcess(location, natureOfBusiness, process, pageable);
        } catch (Exception e) {
            throw new RuntimeException("Error while searching for suppliers: " + e.getMessage());
        }
    }

    public Supplier addSupplier(Supplier supplier) {
        try {
            return supplierRepository.save(supplier);
        } catch (Exception e) {
            throw new RuntimeException("Error while saving the supplier: " + e.getMessage());
        }
    }
}
