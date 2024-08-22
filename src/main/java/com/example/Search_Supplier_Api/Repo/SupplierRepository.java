package com.example.Search_Supplier_Api.Repo;

import com.example.Search_Supplier_Api.Entity.Supplier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface SupplierRepository extends MongoRepository<Supplier, String> {
    Page<Supplier> findByLocationAndNatureOfBusinessAndManufacturingProcess(
            String location,
            String natureOfBusiness,
            String manufacturingProcess,
            Pageable pageable
    );
}
