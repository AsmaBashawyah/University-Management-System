# 🎓 University Management System

## 📌 Overview

A **Java console-based application** for managing university records using **Object-Oriented Programming (OOP)** principles. Each class is implemented in a **separate Java file** within the same package for better organization and maintainability.

---

## 🧱 System Design

The system is built around an abstract base class and specialized subclasses:

```
Person (abstract)
│
├── Student
│
└── Employee (abstract)
    ├── FullTimeEmployee
    └── PartTimeEmployee
```

All objects are stored in a single `List<Person>` to demonstrate **polymorphism**.

---

## ✨ Features

* Add Students, Full-time Employees, and Part-time Employees
* Display all records with formatted output
* Salary calculation based on employee type
* Pass/Fail evaluation for students
* Strong input validation (unique IDs, valid ranges, non-empty values)

---

## 🧠 OOP Concepts Used

* **Inheritance** (Student & Employee inherit from Person)
* **Abstraction** (abstract classes and methods)
* **Polymorphism** (dynamic method overriding)
* **Encapsulation** (protected/private attributes)

---

## ▶️ How to Run

1. Open the project in any Java IDE
2. Run `UniversityManagementSystem.java`
3. Use the console menu to interact with the system

---

## 🛠 Technologies

* Java
* Console-based UI
* Object-Oriented Programming

---

## 👩‍💻 Author

**Asma**

---

This project is intended for learning and practicing OOP concepts in Java.

