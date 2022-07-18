# library-system
Чтобы запустить приложение, вы можете клонировать проект из git и запустить его в Intellij IDEA.
Или запустите команду: 
`gradlew bootRun` в терминале в папке проекта.

Вам нужно создать базу данных librarry-book-samgau на Postgres и указать имя пользователя и пароль в 
application.properties(username=postgres, password=admin).

После запуска приложения вы можете протестировать API с помощью Postman или Insomnia.

После регистрации для каждого запроса необходимо отправить заголовок Authorization со значением StudentId(например: 123456).

В проекте есть готовый файл Insomnia(Insomnia_2022-07-18.json) для тестирования API.
Вы должны импортировать его в свою Insomnia.
