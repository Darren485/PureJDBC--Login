```markdown
# JDBC Login System

A basic authentication system built with raw JDBC and Java.

## Current Features
- User registration
- View all users (admin function)
- SQL injection protection via PreparedStatement
- Proper resource management with try-with-resources

## What's Missing
- Password hashing (⚠️ Currently stores plain text)
- Login authentication
- Input validation
- Comprehensive error handling

## Tech Stack
- Java 17
- MySQL 8.0+
- JDBC Driver: mysql-connector-j-8.4.0
- Built manually via Windows CMD

## Project Structure
```
JDBC-Login/
├── src/
│   └── main/java/dev/
│       ├── App.java
│       ├── Login.java
│       ├── LoginDAO.java
│       └── DB.java
└── lib/mysql-connector-j-8.4.0.jar
```

## Database Setup
```sql
CREATE DATABASE contact;
USE contact;

CREATE TABLE Login (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);
```

## Quick Start
```cmd
# Compile
javac -cp ".;lib/mysql-connector-j-8.4.0.jar" src/main/java/dev/*.java -d .

# Run
java -cp ".;lib/mysql-connector-j-8.4.0.jar;." dev.App
```

## Security Notice
This project currently stores passwords in plain text and is not suitable for production use. BCrypt implementation is planned.

## Next Steps
- Implement password hashing
- Add login authentication
- Improve error handling
- Add input validation
```