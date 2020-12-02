## Технология разработки программного обеспечения
## Лабораторная работа №1: создание микросервиса на Spring Boot с базой данных
### Студент: Лукьянов Александр Владимирович, Группа 3МАС2001
### Цель лабораторной работы: Знакомство с проектированием многослойной архитектуры Web-API (веб-приложений, микро-сервисов).
В рамках лабораторной работы реализовано простое микросервисное приложение на примере базы хранящей настройки сетевого оборудования для региональных офисов (ip-адреса, наименование оборудования, регион) и позволяет взаимодействовать с базой на основе CRUD-запросов.
#### Настройка базы данных
Для хранения данных использована база данных PostgresSQL
Настройки подключения к БД:
Указать логин и пароль пользователя для подключения к БД в файле:
<code>./src/main/resources/application.properties</code>
Логин: <code>spring.datasource.username = </code>
Пароль: <code>spring.datasource.password = </code>
Запуск БД в Docker: <code>docker run -e POSTGRES_PASSWORD=root -p 5432:5432 postgres</code>
Адрес для запуска в локальной среде: <code>jdbc:postgresql://localhost:5432/postgresql</code>
Адрес для запуска в docker-окружении:<code>jdbc:postgresql://192.168.217.33:5432/postgres</code>
Файл с описанием схемы БД: <code>./src/main/resources/schema.sql</code>
Для создания схемы БД:<code>psql -h <адрес_БД> -p <порт_БД> -U <имя_пользователя> -d public -f "schema.sql"</code>
Для заполнения БД данными: <code> ./src/main/resources/data.sql </code>
#### Сборка проекта в Maven
Maven представляет из себя систему сборки проектов в автоматическом режиме, для сборки проекта выполнить команду:
<code>mvn package -Dmaven.test.skip=true</code>
В результате сборки получаем скомпилированный файл: <code>project-01.jar</code>
#### Клонирование репозитория
Для клонирования репозитория необходимо выполнить команду <code>git clone https://github.com/delock1/lab1.git</code>
#### Работа с Docker
Переходим в каталог с docker-файлом и собранным с помощью maven проектом, запускаем сборку docker-образа:
<code> docker build -t project-01:v1 . </code> 
Запуск образа:
<code>docker run -p 8080:8080 project-01:v1 </code>
  
#### Проверка работы микросервиса:
##### Получение hostname: 
<code>curl -X GET http://127.0.0.1:8080/api/v1/status</code>
Возвращает JSON в виде <code>{hostname: "hostname"}</code>. 

##### Получить список оборудования:
<code>curl -X GET http://127.0.0.1:8080/api/v1/devices</code>
Получаем JSON со списком оборудования. 

##### Добавить запись: 
<code>curl -X POST http://127.0.0.1:8080/api/v1/ -d ‘{
  "id": 1,
  "name": "c1941sm",
  "department": "Самара",
  "brand": "cisco",
  "address": "78.86.125.15"
} ’ -H «Content-Type:application/json»</code>
В ответ будет получен статус <code>200 ОК</code>.
##### Удалить запись: 
<code>curl -X POST http://127.0.0.1:8080/api/v1/{id}</code>
В ответ будет получен статус <code>204 No Content</code>.


  
