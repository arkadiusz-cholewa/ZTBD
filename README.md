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


### Endpointy: ###
- #### POST http://localhost:8181/users/sign-up ####
Body: 
```
{
	"username": "john_doe",
	"password": "password",
	"name": "John Doe",
	"admin": true
}
```
- #### POST http://localhost:8181/login ####
Body: 
```
{
	"username": "john_doe",
	"password": "password"
}
```
Response ([JWT](https://jwt.io/)):
```
Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0MiIsImV4cCI6MTU0MjA0MzE3OH0.uMfTMxniNJZGBt0sounLQYh68jQlOotXAgPXyfB8JHyaCe82xmlzc4B5HAL2398cWDnzwJH_3UDCKkKdttDlrA
```
