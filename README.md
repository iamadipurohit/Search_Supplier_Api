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
   ```bash
    mvn spring-boot:run

## Running Test
      
