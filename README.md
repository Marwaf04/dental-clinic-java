# Dental Clinic Management System – Java

A menu-driven command-line application built in Java for managing dental clinic patient records. This system allows users to add, update, search, delete, and export patient data with file persistence using serialization.

## Features

- Add new patient records
- Search patients by health card number
- Delete patients by health card number
- Update patient name, gender, or age
- Display all patients
- Export all patient records to a CSV file
- Save/load patient data to/from a file (clinic_data.txt)

## Technologies Used

- Java (OOP)
- ArrayList for dynamic data management
- Object Serialization (ObjectOutputStream, ObjectInputStream)
- File I/O for CSV export

## How to Compile and Run

### Compile:
```bash
javac DentalClinicDriver.java Clinic.java Individual.java
```

### Run:
```bash
java DentalClinicDriver
```

The application will load existing data from clinic_data.txt if it exists and save updates upon exit.

## File Structure

```
├── DentalClinicDriver.java   # Main menu and program logic
├── Clinic.java               # Handles list of patients and business logic
├── Individual.java           # Defines the patient data model
├── clinic_data.txt           # Stores serialized data
├── patients.csv              # Exported CSV of patients
```

## Author

**Marwa Fekri**  
Software Engineering Student, Concordia University  
GitHub: [@Marwaf04](https://github.com/Marwaf04)
