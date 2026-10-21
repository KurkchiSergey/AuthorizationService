# Сервис авторизации (Spring Boot)

Авторизация пользователя по логину и паролю с обработкой ошибок.

## Запуск

mvn spring-boot:run

Приложение стартует на http://localhost:8080

## Проверка
Валидный пользователь (200, список разрешений):

http://localhost:8080/authorize?user=admin&password=admin123

Тестовые пользователи:
| user   | password  | разрешения            |
|--------|-----------|-----------------------|
| admin  | admin123  | READ, WRITE, DELETE   |
| editor | edit123   | READ, WRITE           |
| guest  | guest123  | READ                  |

## Поведение ошибок
- Пустой логин или пароль → **400 Bad Request**, тело: `User name or password is empty`
 
  http://localhost:8080/authorize?user=&password=
 
- Неизвестный пользователь / неверный пароль / нет разрешений → **401 Unauthorized**, тело: `Unknown user <user>`, плюс запись сообщения в консоль.

  http://localhost:8080/authorize?user=vasya&password=123


