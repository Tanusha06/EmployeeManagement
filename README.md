# EmployeeManagement
A Spring Boot-based Employee Management System using PostgreSQL for data storage and Postman for API testing.

Features
1. Add, update, retrieve employees.
2. Fetch employees by department (IT, HR, FINANCE, SALES).
3. Fetch employees by Id.
4. Update employee salary with validation.
5. EST API endpoints tested using Postman.

Technologies Used
1. Backend: Java, Spring Boot, Spring Data JPA
2. Database: PostgreSQL (pgAdmin 4)
3. API Testing: Postman
4. Version Control: Git & GitHub

Getting Started
1. git clone https://github.com/Tanusha06/EmployeeManagement.git
cd EmployeeManagement
2. Configure PostgreSQL Database
   2.1 Create a PostgreSQL database (eg: employees).
   2.2 Update src/main/resources/application.properties:
   spring.datasource.url=jdbc:postgresql://localhost:5432/employee_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
3. Build and Run the Application
4. API Endpoints: (To Test on POSTMAN)
   4.1 GET     /api/employees                            Get all employees
   4.2 GET     /api/employees/department/{department}    Get employees by department
   4.3 POST   /api/employees                             Add a new employee
   4.4 PUT    /api/employees/{id}/salary                 Update employee salary

5. Contributing
   Feel free to fork this repository, make enhancements, and submit pull requests.




