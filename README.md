# ZTBD (Zaawansowane technologie baz danych)
### Temat projektu: "System rezerwacji pokoi hotelowych" ###

#### Technologie: Java, Spring Boot, PostgreSQL, JPA, Hibernate, JWT ####

### Podstawowe elementy systemu: ###
☑️ logowanie <br/>
☑️ rejestracja
- administracja aplikacją:
  - zarządzanie użytkownikami
  - role / dostępy
  <br/>
☑️ [wersjonowanie bazy danych (liquibase)](https://www.liquibase.org/)
- zaproponować sposób przechowywania:
  - plików
  - słowników
  - StaticResources np. teksty dla UI
- appliaction logger / events
- [keep a changelog](https://keepachangelog.com/en/1.0.0/)
- miejsce przechowywania ustawień aplikacji

---

### Połączenie z bazą danych ###
1. Do katalogu `ZTBD\src\main` dodaj katalog `resources`.
2. Do katalogu `resources` dodaj plik `application.properties`.
3. Uzupełnij plik `application.properties`:
```
## Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
server.port=8181
spring.datasource.url=<url>
spring.datasource.username=<username>
spring.datasource.password=<password>

# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update
```

---
### Endpoints: ###
#### POST http://localhost:8181/sign-up ####
Body: 
```
{
	"username": "john_doe",
	"password": "password",
	"name": "John Doe",
	"role": "USER" // "CLIENT", "ADMIN", "EMPLOYEE"
}
```

#### POST http://localhost:8181/login ####
Body: 
```
{
	"username": "john_doe",
	"password": "password"
}
```
Response ([JWT](https://jwt.io/)):
```
Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqb2huX2RvZSIsImV4cCI6MTU0MjA0MzU4N30.WkuFu2kOyvqkxwm3uzEaRYerrSqCdxzhrgFpKKSS8GG1k98-fqEj0vGHkL-X9VmUZAu-vrKLjwCXoQCAHD_4LQ
```
