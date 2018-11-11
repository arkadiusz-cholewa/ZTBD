# ZTBD (Zaawansowane technologie baz danych)
### Temat projektu: "System rezerwacji pokoi hotelowych" ###

### Podstawowe elementy systemu: ###
- logowanie
- rejestracja
- administracja aplikacją:
  - zarządzanie użytkownikami
  - role / dostępy
- zaproponować sposób przechowywania:
  - plików
  - słowników
  - StaticResources np. teksty dla UI
- appliaction logger / events
- miejsce przechowywania ustawień aplikacji


### Endpoints: ###
#### POST http://localhost:8181/users/sign-up ####
Body: 
```
{
	"username": "john_doe",
	"password": "password",
	"name": "John Doe",
	"admin": true
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
