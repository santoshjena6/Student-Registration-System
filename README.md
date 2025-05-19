# Student Registration System 🎓

A simple Spring Boot project that manages student records with full CRUD operations.

## 🔧 Technologies Used
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- OracleDB
- Maven

## 📁 Project Structure
- **Entity Layer**: Represents the Student object
- **Repository Layer**: JPA Repository for database access
- **Service Layer**: Business logic
- **Runner**: Loads sample data on startup using CommandLineRunner
- **application.properties**: Configuration for DB and JPA

## ✅ Features
- Create, Read, Update, Delete student records
- Layered architecture (Entity → Repository → Service)
- Auto DDL & SQL logging through configuration

