package com.example.Search_Supplier_Api.Controller;

import com.example.Search_Supplier_Api.Entity.Supplier;
import com.example.Search_Supplier_Api.Services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/query")
    public ResponseEntity<?> searchSuppliers(
            @RequestParam String location,
            @RequestParam String natureOfBusiness,
            @RequestParam String process,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {

        // Manual validation
        if (location == null || location.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Location is required");
        }

        if (natureOfBusiness == null || (!natureOfBusiness.equals("small_scale")
                && !natureOfBusiness.equals("medium_scale")
                && !natureOfBusiness.equals("large_scale"))) {
            return ResponseEntity.badRequest().body("Invalid nature of business. Valid values are: small_scale, medium_scale, large_scale");
        }

        if (process == null || (!process.equals("moulding")
                && !process.equals("3d_printing")
                && !process.equals("casting")
                && !process.equals("coating"))) {
            return ResponseEntity.badRequest().body("Invalid manufacturing process. Valid values are: moulding, 3d_printing, casting, coating");
        }

        try {
            Page<Supplier> suppliers = supplierService.searchSuppliers(location, natureOfBusiness, process, page, size);
            return ResponseEntity.ok(suppliers);
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<?> addSupplier(@RequestBody Supplier supplier) {
        try {
            Supplier savedSupplier = supplierService.addSupplier(supplier);
            return ResponseEntity.ok(savedSupplier);
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body("An error occurred while saving the supplier: " + e.getMessage());
        }
    }
}
