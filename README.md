
# JDBC Login System

A **pure JDBC** authentication system built with **raw Java** — no Spring, no IDE, no mouse.

---

## Features
- Register new users
- View all users (admin)
- SQL injection proof (`PreparedStatement`)
- Zero resource leaks (`try-with-resources`)

---

## Missing (On Purpose)
- Password hashing *(plain text for learning)*
- Login authentication
- Input validation

---

## Tech Stack
- Java 17
- MySQL 8.0+
- JDBC Driver: `mysql-connector-j-8.4.0`
- Built in **Windows CMD**

---

## Project Structure
```
JDBC-Login/
├── src/
│   └── main/java/dev/
│       ├── App.java
│       ├── Login.java
│       ├── LoginDAO.java
│       └── DB.java
└── lib/
    └── mysql-connector-j-8.4.0.jar
```

---

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

---

## Run (CMD)
```cmd
javac -cp ".;lib/mysql-connector-j-8.4.0.jar" src/main/java/dev/*.java -d .
java -cp ".;lib/mysql-connector-j-8.4.0.jar;." dev.App
```

---

## Security Warning
> **Passwords stored in plain text**  
> Not for production. BCrypt coming soon.

---

## Next Steps
- [ ] Add **BCrypt hashing**
- [ ] Add **Login function**
- [ ] Input validation
- [ ] Convert to **Spring Boot + JWT (7 lines)**

---

**Built by Asuquo Bassey (Darren485)**  
**Lagos, Nigeria** — 11 Nov 2025, 03:28 PM WAT  
**Open for Junior Java roles**

[GitHub](https://github.com/Darren485) | [X/Twitter](https://twitter.com/SukiBass)
``` 