# Support Ticket System — Spring Boot + MongoDB

A Java 17 REST API starter project using Spring Boot, Spring Web, Spring Data MongoDB, Bean Validation, and Maven.

## Features
- Create, list, retrieve, update, and delete support tickets (CRUD)
- Filter tickets by status or requester email
- Validation for required fields and email format
- JSON error responses for invalid requests and missing tickets
- Creation and update timestamps

## Requirements
- JDK 17+
- Maven 3.6+
- MongoDB Community Server running locally, or a MongoDB Atlas connection string
- Postman (recommended)

## Run locally
1. Install and start MongoDB. Default connection: `mongodb://localhost:27017/support_ticket_db`.
2. Open a terminal in the project root.
3. Run `mvn spring-boot:run`.
4. API base URL: `http://localhost:8080/api/tickets`.

For MongoDB Atlas or another server, set the environment variable `MONGODB_URI` to your connection string. Do not commit credentials to GitHub. MongoDB creates the database and collection when the first ticket is saved.

## API endpoints
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/tickets` | Create a ticket |
| GET | `/api/tickets` | List all tickets |
| GET | `/api/tickets/{id}` | Get a ticket by MongoDB ID |
| PUT | `/api/tickets/{id}` | Update a ticket |
| DELETE | `/api/tickets/{id}` | Delete a ticket |
| GET | `/api/tickets?status=OPEN` | Filter by status |
| GET | `/api/tickets?requesterEmail=user@example.com` | Filter by requester email |

Priority values: `LOW`, `MEDIUM`, `HIGH`, `URGENT`.
Status values: `OPEN`, `IN_PROGRESS`, `RESOLVED`, `CLOSED`.

## Example POST request
`POST http://localhost:8080/api/tickets` with header `Content-Type: application/json`:
```json
{
  "title": "Cannot reset password",
  "description": "The password reset email is not arriving.",
  "requesterName": "Bhuvi",
  "requesterEmail": "bhuvi@example.com",
  "priority": "HIGH",
  "status": "OPEN"
}
```

Send the POST request in Postman, then call `GET http://localhost:8080/api/tickets` to verify the saved ticket.

## Structure
- `controller` — REST endpoints
- `service` — business logic
- `repository` — MongoDB access
- `entity` — MongoDB document and enums
- `dto` — validated request body
- `exception` — API error responses

This is a clean starter backend, not an automatic migration of an existing JDBC/MySQL project. It has no frontend or authentication yet. Add Spring Security and role-based authorization after the CRUD API is working.
