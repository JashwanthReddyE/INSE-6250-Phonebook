Welcome to the Java Phonebook application—a robust and secure system designed to manage your 
contact information efficiently. This application allows users to securely log in using a username 
and password. Upon successful authentication, users gain access to a comprehensive interface 
where they can manage their contacts through basic CRUD (Create, Read, Update, Delete) 
operations.
We have used ports and adapters Architecture also known as Hexagonal architecture which 
supports data abstraction and business logic security. i.e. Business logic and data processing is 
independent of each other and is possible using data models which are defined.

Key Features:
Secure Authentication: Users must log in with valid credentials to access the system.
Contact Management: Users can add, view, modify, and remove contact records through a userfriendly interface.
Data Validation: Ensures the integrity of the data entered into the system. Each field in a contact's 
record is validated according to specific rules to prevent errors and maintain data quality.
Data Abstraction: Data abstraction in the Java phonebook application is implemented through a 
layered architectural approach, where each layer abstracts certain aspects of the application's 
functionality, allowing developers to interact with complex data operations easily.

Data Validation Rules:
The application enforces strict validation rules to ensure that all contact information is accurate 
and follows a standardized format. Below is a summary of the validation criteria for each field in 
a contact record:

First Name: Accepts text input with/without spaces representing the contact's first name.
Last Name: Accepts text input with/without spaces representing the contact's last name.
Company: Accepts text input with/without spaces for the contact's associated company.
Phone: Must match the numbering format, e.g., +1NNN.NNN.NNNN
Email: Valid email address format is required.
Website: Must be valid website URL(web).toURI().
Address - Unit Number: Numeric input for the unit number of the contact’s address.
Address - Civic Number: Numeric input for the building number of the contact’s address.
Address - Street: Text input for the street part of the contact’s address.
Address - City: Text input for the city part of the contact’s address.
Address - Province: Requires a two-letter capitalized code representing the province.
Address - Postal Code: Must follow the Canadian postal code format, e.g., ANA NAN, where 'A' 
is a letter and N is a number.

This documentation aims to guide users through the setup, daily use, and troubleshooting of the 
Java Phonebook application. By adhering to the outlined validation rules, the application ensures 
that all contact information stored is both accurate and formatted correctly, enhancing usability 
and reliability.
