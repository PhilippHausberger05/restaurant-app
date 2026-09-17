# Restaurant Ordering System

A REST API for a restaurant ordering system, built as a portfolio project to learn backend development with Java and Spring Boot.

## Tech Stack

- Java 21
- Spring Boot 4.1 (Spring Web, Spring Data JPA)
- PostgreSQL
- Maven

## Features

- Layered architecture (model / repository / controller)
- Full CRUD for menu items (`Gericht`) and customers (`Kunde`)
- Domain validation enforced in the entity itself, not just at the API layer
- Centralized error handling with meaningful JSON error responses
- Order domain modeled with `Bestellung` / `Bestellposition` entities, `@ManyToOne`/`@OneToMany` relationships, and a `BestellStatus` enum
- Order creation via `Bestellung` REST endpoints, with `BestellungRequest`/`PositionRequest` DTOs decoupling the API from the entity structure
- Order-status workflow with transition rules (one step forward or back only) via `PUT /bestellungen/{id}/status`
- Unit test coverage for entity validation logic using Junit 5 for `Gericht`, `Kunde`, `Bestellung`, `Bestellposition`
- Persistent database storage via a named Docker volume, surviving container recreation
- Authentication with Spring Security (HTTP Basic), BCrypt password hashing, and unique email constraint
- Role-based authorization (USER / ADMIN): menu management and order status changes are admin-only

## Running Locally

### With Docker
1. Copy `.env.example` to `.env` and set `DB_PASSWORD`
2. Run `docker compose up --build`
3. App available at `http://localhost:8080`
4. Use `docker compose down` to stop (data is preserved); `docker compose down -v` also deletes the database volume

### Without Docker
1. Create a PostgreSQL database named `restaurant`
2. Set the `DB_PASSWORD` environment variable to your PostgreSQL password
3. Run `RestaurantAppApplication` — the app starts on `http://localhost:8080`

### Creating an admin user

New accounts are always created with the `USER` role — self-assigning `ADMIN` is deliberately not possible. To grant admin rights, update the user directly in the database:

1. Register a user via `POST /kunden`
2. Connect to the database:
   - Docker: `docker compose exec db psql -U postgres -d restaurant`
   - Local: `psql -U postgres -d restaurant`
3. Promote the user: `- c" UPDATE kunde SET rolle = 1 WHERE email = 'your@email.com';"`
4. Restart is not required — the role is read on each login

Roles are stored by their ordinal position: `0` = USER, `1` = ADMIN.

## API Endpoints

Public: `GET /gerichte/**`, `POST /kunden`. Admin-only: creating, updating and deleting menu items, and changing order status. All other endpoints require authentication.

| Method | Path            | Description          |
|--------|-----------------|-----------------------|
| GET    | /gerichte       | List all menu items  |
| GET    | /gerichte/{id}  | Get one menu item    |
| POST   | /gerichte       | Create a menu item   |
| PUT    | /gerichte/{id}  | Update a menu item   |
| DELETE | /gerichte/{id}  | Delete a menu item   |
| GET    | /kunden         | List all customers   |
| GET    | /kunden/{id}    | Get one customer     |
| POST   | /kunden         | Create a customer    |
| PUT    | /kunden/{id}    | Update a customer    |
| DELETE | /kunden/{id}    | Delete a customer    |
| GET    | /bestellungen       | List all orders       |
| GET    | /bestellungen/{id}  | Get one order         |
| POST   | /bestellungen       | Create a new order    |
| PUT    | /bestellungen/{id}/status | Change order status |
