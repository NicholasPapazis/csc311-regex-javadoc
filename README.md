# Registration Form Application

## Overview

This JavaFX application is a registration form designed with input validations to ensure user data integrity. The form collects essential user information, including First Name, Last Name, Email, Date of Birth, and Zip Code. The application provides real-time feedback on the validity of the input fields and enables the "Register" button only when all inputs are valid.

## Features

- **User-Friendly Interface**: Clean, attractive, and intuitive design using JavaFX.
- **Input Fields**:
  - **First Name**: Minimum 2 characters, maximum 25 characters.
  - **Last Name**: Minimum 2 characters, maximum 25 characters.
  - **Email**: Accepts only valid Farmingdale email addresses.
  - **Date of Birth**: Must be in MM/DD/YYYY format.
  - **Zip Code**: Must be a 5-digit number.
- **Real-Time Validation**: User feedback provided as they navigate between fields.
- **Dynamic Button State**: "Register" button is enabled only when all fields contain valid data.
- **Navigation**: Redirects to a new UI upon successful submission.

## Requirements

- **Java**: Ensure Java Development Kit (JDK) is installed.
- **JavaFX**: JavaFX must be set up for your environment.
