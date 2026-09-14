# Restaurant Ordering System

A REST API for a restaurant ordering system, built as a portfolio project to learn backend development with Java and Spring Boot.

## Tech Stack

- Java 21
- Spring Boot 4.1 (Spring Web, Spring Data JPA)
- PostgreSQL
- Maven

## Features (in progress)

- Layered architecture (model / repository / controller)
- Full CRUD for menu items (`Gericht`) and customers (`Kunde`)
- Domain validation enforced in the entity itself, not just at the API layer
- Centralized error handling with meaningful JSON error responses
- Order domain modeled with `Bestellung` / `Bestellposition` entities, `@ManyToOne`/`@OneToMany` relationships, and a `BestellStatus` enum

## Running Locally

1. Create a PostgreSQL database named `restaurant`
2. Set the `DB_PASSWORD` environment variable to your PostgreSQL password
3. Run `RestaurantAppApplication` — the app starts on `http://localhost:8080`

## API Endpoints

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
