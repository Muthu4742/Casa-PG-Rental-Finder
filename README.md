# Casa – Rental & PG Finder (Full Stack)

This folder contains:

- `backend/` – Spring Boot REST API with PostgreSQL
- `frontend/` – (placeholder) React app folder where you can create your React project.

## Backend

- Java 21
- Spring Boot 3
- PostgreSQL
- REST APIs for auth and property management.

### Run backend

1. Create database in PostgreSQL:

   ```sql
   CREATE DATABASE casa_pg;
   ```

2. Edit `backend/src/main/resources/application.properties` and set your DB password.

3. From `backend/` folder, run:

   ```bash
   mvn clean spring-boot:run
   ```

Backend will start on `http://localhost:8080`.

## Frontend

Create a React app inside `frontend/`:

```bash
cd frontend
npx create-react-app .
npm start
```

Then call backend APIs like:

- `POST http://localhost:8080/api/auth/register`
- `POST http://localhost:8080/api/auth/login`
- `GET  http://localhost:8080/api/properties`
