# FMTALI_VehicleRegistration

A simple Java console application for registering and managing vehicle information. This system allows users to capture vehicle details, validate license plates for both old and new South African formats, and generate vehicle reports with persistent data storage.

## Features

- **Vehicle Registration**: Capture comprehensive vehicle details including owner name, make, model, VIN number, license plate, and year
- **License Plate Validation**: Supports both old (AAA-111-GP) and new (AA-11-BB-GP) South African license plate formats
- **VIN Number Validation**: Ensures VIN numbers are exactly 17 characters long
- **Vehicle Reports**: Generate detailed reports for registered vehicles
- **Data Persistence**: Automatically saves and loads vehicle data using Java serialization
- **User-Friendly Interface**: Interactive console-based menu system

## System Requirements

- Java 8 or higher
- Sufficient disk space for data storage (car.ser file)

## Installation

1. Clone or download the project files
2. Ensure you have Java installed on your system
3. Compile the Java files:
   ```bash
   javac -d . car/Car.java vehicleregistration/VehicleRegistration.java
   ```

## Usage

1. Run the application:
   ```bash
   java vehicleregistration.VehicleRegistration
   ```

2. Follow the interactive prompts:
   - Enter your name when prompted
   - Choose from the menu options:
     - **(1) Capture vehicle details**: Register a new vehicle
     - **(2) View vehicle report**: Display all vehicles registered under your name
     - **(3) Exit**: Close the application

3. When registering a vehicle, you'll need to provide:
   - Vehicle make and model
   - 17-character VIN number
   - License plate type (old or new format)
   - License plate number
   - Vehicle year

## License Plate Formats

### Old Format (Type 1)
- Pattern: `AAA-111-GP`
- Example: `JHB-123-GP`

### New Format (Type 2)
- Pattern: `AA-11-BB-GP`
- Example: `CA-12-AB-GP`

## Project Structure

```
├── car/
│   └── Car.java                    # Car model class with serialization support
├── vehicleregistration/
│   └── VehicleRegistration.java    # Main application class
├── car.ser                         # Generated data file (created automatically)
└── README.md                       # This file
```

## Data Storage

The application uses Java object serialization to persist data in a file called `car.ser`. This file is automatically created in the application directory and stores all registered vehicle information.

## Error Handling

The application includes robust error handling for:
- Invalid VIN numbers (must be exactly 17 characters)
- Incorrect license plate formats
- Invalid year entries (non-numeric input)
- File I/O operations

## Future Enhancements

- Database integration for better data management
- Search functionality by VIN or license plate
- Vehicle update and deletion capabilities
- Export reports to PDF or other formats
- Multi-user support with authentication

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Contact

**Developer**: [Athini Mgagule]  
**Email**: [athinimgagule03@gmail.com]  
**GitHub**: [https://github.com/AthiniMgagule](https://github.com/AthiniMgagule)  

---

*Thank you for using the Vehicle Registration System! If you encounter any issues or have suggestions for improvements, please don't hesitate to reach out.*
