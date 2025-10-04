
# 🎬 MovieServlet – A Simple Movie Management Servlet

## 📘 Overview

**MovieServlet** is a Java-based web application built using **Jakarta Servlet API** that allows users to **insert and retrieve movie details** from a MySQL database.
It demonstrates core concepts of **JDBC (Java Database Connectivity)**, **Servlets**, and **HTML form handling**.

---

## 🚀 Features

* Insert movie details (name, actor, actress, director, release date, and rating) into a MySQL database.
* Retrieve and display all movie records after insertion.
* Error handling for invalid inputs and database issues.
* Easy to integrate with a frontend HTML form.

---

## 🧰 Technologies Used

| Component          | Technology                               |
| ------------------ | ---------------------------------------- |
| **Backend**        | Java Servlet (Jakarta EE)                |
| **Database**       | MySQL                                    |
| **Driver**         | MySQL Connector/J                        |
| **Server**         | Apache Tomcat (v10 or above recommended) |
| **IDE (Optional)** | Eclipse / IntelliJ IDEA / NetBeans       |

---

## 🗂️ Project Structure

```
MovieServletProject/
├── src/
│   └── movie/
│       └── MovieServlet.java
├── WEB-INF/
│   ├── web.xml  (if not using annotations)
│   └── lib/
│       └── mysql-connector-j-<version>.jar
├── index.html   (form to submit movie data)
└── README.md
```

---

## ⚙️ Database Setup

### 1️⃣ Create Database

Open **MySQL** and execute the following commands:

```sql
CREATE DATABASE bcapracticals;
USE bcapracticals;
```

### 2️⃣ Create Table

```sql
CREATE TABLE movie (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  actor VARCHAR(100),
  actress VARCHAR(100),
  director VARCHAR(100),
  releaseDate DATE,
  ratePoint FLOAT
);
```

---

## 🧩 Configuration

### 🔹 MySQL Connection Details

Make sure the following connection parameters in `MovieServlet.java` match your system setup:

```java
String url = "jdbc:mysql://localhost:3306/bcapracticals";
String user = "root";
String password = "password"; // Replace with your MySQL password
```

### 🔹 Add MySQL Connector

* Download the latest MySQL Connector/J (`mysql-connector-j-8.x.x.jar`)
* Place it in:

  ```
  WEB-INF/lib/
  ```

---

## 🖥️ How It Works

### 📝 1. HTML Form Example

Create a simple form (`index.html`) to post data to the servlet:

```html
<form action="MovieServlet" method="post">
  Movie Name: <input type="text" name="name"><br>
  Actor: <input type="text" name="actor"><br>
  Actress: <input type="text" name="actress"><br>
  Director: <input type="text" name="director"><br>
  Release Date (YYYY-MM-DD): <input type="text" name="rDate"><br>
  Rating (0.0 - 10.0): <input type="text" name="rPoint"><br>
  <input type="submit" value="Add Movie">
</form>
```

### 🗃️ 2. On Form Submission

* The servlet reads input parameters.
* Connects to MySQL using JDBC.
* Inserts a new movie record.
* Fetches and displays all existing movies.

---

## 🔍 Example Output

```
Values Inserted Successfully
ID: 1
Name: Inception
Actor: Leonardo DiCaprio
Actress: Ellen Page
Director: Christopher Nolan
Release Date: 2010-07-16
RatePoint: 9.0
```

---

## ⚠️ Error Handling

If something goes wrong (like invalid date or DB connection error), you’ll see:

```
Error: <error message>
```

and the stack trace will appear in the server logs.

---

## 🧪 Testing

* Run your Tomcat server (version 10+).
* Deploy your project.
* Access it in your browser at:

  ```
  http://localhost:8080/MovieServletProject/index.html
  ```
* Fill the form and submit to see results.

---

## 📄 License

This project is open-source and free to use for educational and learning purposes.

---

## ✨ Author

**Developed by:** Yashvardhan Reddy
📧 *For academic use and servlet learning.*

---...
