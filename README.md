
# EyeClear Prescription App

The **EyeClear Prescription App** is a Java-based application designed to handle and store patient prescription details for optometrists. It allows users to add validated prescriptions and manage up to two remarks per prescription, ensuring all data is accurate and conforms to set constraints.

## Features

### 1. **Prescription Management**
- Add a new patient prescription with the following fields:
  - First Name (4-15 characters)
  - Last Name (4-15 characters)
  - Address (minimum 20 characters)
  - Sphere (between -20.00 and +20.00)
  - Cylinder (between -4.00 and +4.00)
  - Axis (between 0 and 180 degrees)
  - Exam Date (in `DD/MM/YY` format)
  - Optometrist Name (8-25 characters)
- Validates input fields to ensure they meet the requirements before storing the prescription.

### 2. **Remark Management**
- Add up to two remarks for each prescription.
  - Remarks must have between 6 and 20 words.
  - The first word of the remark must start with a capital letter.
- Categorize remarks as either:
  - **Optometrist** (written by the optometrist)
  - **Client** (written by the client/patient)
- Rejects a third remark if two remarks have already been added.

### 3. **Data Persistence**
- All prescriptions and remarks are saved to text files:
  - **presc.txt** stores prescription details.
  - **review.txt** stores remarks associated with each prescription.

## Installation and Setup



1. **Open the Project**:
   - Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).

2. **Run the Application**:
   - Ensure you have the correct Java version installed (e.g., JDK 8 or higher).
   - Compile and run the `MainApp.java` file from the `src` directory.

## Usage

### Adding a Prescription
1. Run the application.
2. Enter valid prescription details when prompted, including the patient's first name, last name, address, sphere, cylinder, axis, exam date, and optometrist's name.
3. If all inputs are valid, the prescription will be added and stored in the `presc.txt` file.

### Adding Remarks
1. After adding a prescription, add remarks by entering a remark and selecting a category (either "optometrist" or "client").
2. Each remark must contain 6 to 20 words and start with a capital letter.
3. You can add up to two remarks per prescription. Attempting to add more will result in an error.

## Example

Here’s an example of adding a prescription and two remarks:

```text
First Name: John
Last Name: Doeh
Address: 123 Example Street, Suburb, Country, 12345
Sphere: -1.50
Cylinder: -2.25
Axis: 90
Exam Date: 23/10/24
Optometrist: Dr. Anderson
Prescription added successfully!

Adding Remark: Patient shows significant improvement in their overall condition.
Category: optometrist
Remark added successfully!

Adding Remark: Client reports vision has improved significantly since the last visit.
Category: client
Remark added successfully!

Trying to add a third remark...
Failed to add third remark as expected (maximum 2 remarks allowed).
```

## Project Structure

```text
EyeClearPrescriptionApp/
├── data/
│   ├── presc.txt          # Stores prescription data
│   └── review.txt         # Stores remarks
├── src/
│   ├── Prescription.java  # Prescription handling class
│   ├── Remark.java        # Remark handling class
│   ├── MainApp.java       # Main application entry point
├── .gitignore             # Gitignore file
└── README.md              # Project documentation
```

## Future Enhancements
- Add functionality to edit or delete existing prescriptions and remarks.
- Implement a graphical user interface (GUI) for a better user experience.
- Integrate with a database for persistent data storage.

## Conclusion
The **EyeClear Prescription App** is a simple, yet effective tool for managing patient prescription data and associated remarks, ensuring validation and data accuracy. The app can be expanded with additional features like editing, deletion, and GUI integration to improve usability.

