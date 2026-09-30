# PixelVault

A responsive web application for managing a personal image gallery — upload, preview, organize, search, and delete images through a clean browser interface.

**Tech stack:** HTML, CSS, Java, JSP, MySQL, Apache Tomcat

---

## Overview

PixelVault provides session-based user authentication and a portfolio workspace where authenticated users can store image files with metadata (name, tags, description). An optional admin area supports user and gallery management for demonstration and maintenance.

---

## Features

- User registration and login with session authentication
- Image upload from the local device
- Portfolio browsing with image preview
- Edit image metadata and remove images
- Search by image name or tags
- Password change and account deletion
- Admin console for user and image administration

---

## Repository layout

```
PixelVault/
├── README.md
├── .gitignore
└── src/main/
    ├── java/      # Servlets and model classes
    └── webapp/    # JSP views, static assets, uploads directory
```

---

## Requirements

- JDK 17 or later
- Apache Tomcat 10.x (Jakarta Servlet)
- MySQL 8.x
- MySQL Connector/J on the application classpath (`WEB-INF/lib`)

---

## Getting started

1. Import this folder into Eclipse as a Dynamic Web Project, or package and deploy it to Tomcat.
2. Create a MySQL database and configure the JDBC URL, username, and password in the servlet layer to match your local environment (defaults target `localhost:3306`).
3. Point the image upload directory in `user_addnew.java` to a writable path on your machine.
4. Start Tomcat and open `index.jsp` under the deployed context root (for example `http://localhost:8080/PixelVault/index.jsp`).

The login page supports both standard user access and admin access (via the admin option on the form).
