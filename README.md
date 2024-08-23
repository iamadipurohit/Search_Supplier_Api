# Search Supplier API

## Overview

This Spring Boot application provides endpoints to search and manage suppliers. The API allows querying suppliers based on location, nature of business, and manufacturing processes. It also supports adding new suppliers.

## Prerequisites

- **Java 11** or higher
- **Maven 3.6.0** or higher
- **MongoDB** (Ensure the MongoDB server is running)

## Setup

1. **Clone the Repository**

   ```bash
   git clone https://github.com/your-username/Search_Supplier_Api.git
   cd Search_Supplier_Api

2. **Install Dependencies**
    ```bash
    mvn install

3. **Configure MongoDB**
   ```bash
   spring.data.mongodb.host=localhost
   spring.data.mongodb.port=27017
   spring.data.mongodb.database=your-database-name

## Running the Application
1. Start the Spring Boot application:
   ```bash
   mvn spring-boot:run
2. The application will start on http://localhost:8080.

## Testing the Tool
1. GET /api/supplier/query

Retrieve a list of suppliers based on the following parameters:

- 1. `location` (required): City where the supplier is located.
- 2. `natureOfBusiness` (required): Type of business. Possible values are:
  - `small_scale`
  - `medium_scale`
  - `large_scale`
- 3. `process`** (required): Manufacturing process. Possible values are:
  - `moulding`
  - `3d_printing`
  - `casting`
  - `coating`
- 4. `page` (optional): Page number for pagination. Default is `0` (first page).
- 5. `size` (optional): Number of results per page. Default is `10`.

2. Example Request:

   ```bash
   curl -X GET "http://localhost:8080/api/supplier/query?location=India&natureOfBusiness=small_scale&process=3d_printing&page=1&size=5"

3. Example Response
   ```bash
   [
    {
        "supplierId": "123",
        "companyName": "Test Company",
        "website": "https://testcompany.com",
        "location": "India",
        "natureOfBusiness": "small_scale",
        "manufacturingProcess": "3d_printing"
    }
   ]

## Contact
 For any questions or issues, please contact iamadipurohit@gmail.com

      
