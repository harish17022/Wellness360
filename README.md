# Wellness360
# Tasks Manager API

A RESTful API for managing tasks using Spring Boot, Hibernate, and MySQL. Perform CRUD operations, update task status, and track timestamps.

## Features

- Create, retrieve, update, and delete tasks.
- Mark tasks as completed.
- Task statuses: `Pending`, `In Progress`, `Completed`.
- Auto-managed timestamps (`created_at`, `updated_at`).

## Endpoints

| Method | Endpoint               | Description               |
|--------|------------------------|---------------------------|
| GET    | `/tasks`               | Get all tasks            |
| GET    | `/tasks/{id}`          | Get task by ID           |
| POST   | `/tasks`               | Create a new task        |
| PUT    | `/tasks/{id}`          | Update a task            |
| DELETE | `/tasks/{id}`          | Delete a task            |
| PATCH  | `/tasks/{id}/complete` | Mark task as complete    |

## Quick Start

1. **Clone the repo**:
   ```bash
   git clone https://github.com/harish17022/Wellness360.git
   cd Wellness360

2. **Setup database**:

   Open `src/main/resources/application. properties` and configure:
   ```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/tasks_db
   spring.datasource.username=root
   spring.datasource.password=harish
   spring.jpa.hibernate.ddl-auto=update

3. **Run the app**:
   ```bash
   mvn clean install
   mvn spring-boot:run

   API is available at `http://localhost:8080`.
   
API is available at `http://localhost:8080`.

## Database Schema

    
    CREATE TABLE tasks (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        title VARCHAR(255) NOT NULL,
        description TEXT,
        due_date DATE NOT NULL,
        status ENUM('PENDING', 'IN_PROGRESS', 'COMPLETED') NOT NULL,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    );


## Technologies Used

- **Spring Boot**: Backend framework.
- **Spring Data Jpa**: ORM for database operations.
- **MySQL**: Production database.
- **H2 Database**: Testing database.
- **Lombok**: Simplifies Java code.
- **JUnit 5**: Unit testing.

## Author

Harish Kumar Yampalaku


  


