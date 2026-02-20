# 💰 Personal Finance Tracker API

A production-style RESTful backend application built using **Spring Boot** to manage personal income, expenses, tax deductions, and financial summaries.

This project demonstrates clean layered architecture, JPA relationships, custom aggregation queries, and real-world financial logic implementation using SQL Server.

---

## 🚀 Overview

The Personal Finance Tracker API allows users to:

- Create and manage user profiles
- Record income sources
- Record expense transactions
- Automatically calculate tax deductions
- Generate financial summary reports
- Compute net profit after tax

The system follows a clean architecture pattern:

```
Controller → Service → Repository → Database
```

---

## 🏗 Tech Stack

- **Java 21**
- **Spring Boot 3.x**
- **Spring Data JPA (Hibernate ORM)**
- **Microsoft SQL Server**
- **Maven**
- **Lombok**
- **Git & GitHub**

---

## 🗄 Database Schema

### User
| Field | Type |
|-------|------|
| id | Long (Primary Key) |
| name | String |
| email | String |
| taxPercentage | Double |

### Income
| Field | Type |
|-------|------|
| id | Long (Primary Key) |
| amount | Double |
| source | String |
| date | LocalDate |
| user_id | Foreign Key |

### Expense
| Field | Type |
|-------|------|
| id | Long (Primary Key) |
| amount | Double |
| description | String |
| date | LocalDate |
| user_id | Foreign Key |

**Relationship Design:**

- One User → Many Income records  
- One User → Many Expense records  

---

## 📊 Financial Calculation Logic

For a given user:

```
Total Income  = SUM(income.amount)
Total Expense = SUM(expense.amount)
Tax Amount    = Total Income × (taxPercentage / 100)
Net Profit    = Total Income − Total Expense − Tax Amount
```

Custom JPQL aggregation queries are used to compute totals efficiently at the database level.

---

## 🌐 API Endpoints

### 👤 User Management
```
POST   /api/users
GET    /api/users/{id}
```

### 💰 Income Management
```
POST   /api/incomes/{userId}
GET    /api/incomes
```

### 💸 Expense Management
```
POST   /api/expenses/{userId}
GET    /api/expenses
```

### 📈 Financial Summary
```
GET    /api/finance/summary/{userId}
```

Example Response:

```json
{
  "totalIncome": 50000,
  "totalExpense": 20000,
  "taxAmount": 5000,
  "netProfit": 25000
}
```

---

## ⚙ Configuration

Update `application.properties`:

```properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=personal_finance
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🧠 Architectural Highlights

- Clean separation of concerns (Controller / Service / Repository)
- Entity relationships with `@ManyToOne`
- Custom JPQL queries with `SUM()` aggregation
- Business logic encapsulated in Service layer
- Hibernate-managed schema updates
- RESTful API design principles

---

## 📌 Future Enhancements

- JWT-based authentication & authorization
- Pagination & filtering
- Monthly financial analytics
- Docker containerization
- Cloud deployment (AWS / Azure)

---

## 👨‍💻 Author

Gowtham B  
Backend Developer | Final Year Engineering Student
