## 1) Чтобы скачать с гитхаба проект и запустить, делаем следующие шаги:
#### 1.1) Создаем пустую папку на рабочем столе(можно в других местах) и задаем любое имя.
#### 1.2) Открываем командную строку. Через командную строку переходим в ту папку который создали или заходим в эту папку, и на верху будет путь к этой папке,
![image](https://user-images.githubusercontent.com/57407430/122340904-af520780-cf64-11eb-9e29-ac6abf0d358d.png)

нажимаем на это место 

![image](https://user-images.githubusercontent.com/57407430/122341166-fdffa180-cf64-11eb-8c94-a45463d55603.png)

и пишем cmd.

![image](https://user-images.githubusercontent.com/57407430/122341297-24bdd800-cf65-11eb-8c5c-8bbd08054556.png)


#### 1.3) После выполнения 1.2 пункта, в командной строке пишем '<i>git clone https://github.com/FerrumRT/School.git</i>'.
#### 1.4) Ждем... Появляется новая папка "School" в котором есть проект.


## 2) DataBase(MySql)
#### 2.1) Заходим в XAMPP. Запускаем сервера "Apache" и "MySQL"
#### 2.2) Переходим на ссылку http://localhost/phpmyadmin. Заходим в вкладку "Импорт"
![image](https://user-images.githubusercontent.com/57407430/122372437-7cb70780-cf82-11eb-8c3f-304ebe04b205.png)
#### 2.3) Выбираем файл "school.sql"
![image](https://user-images.githubusercontent.com/57407430/122372707-b6880e00-cf82-11eb-9928-0f9017392645.png)
#### 2.4) Ничего другого не меняем и снизу нажимаем "Вперед"
#### 2.5) Все, база готова(пороли учителей "qweqwe")

## 3) Backend
#### 3.1) Входим внутрь и открываем папку "backend". 
#### 3.2) Открываем проект на редакторе(например IntellijIdea(использую я) или другие.) и ждем сборки проекта.
#### 3.3) После сборки проекта заходим в папку src -> main -> java -> kz.school.School -> открываем файл SchoolApplication и запускаем этот файл(этот файл запускает проект)
#### 3.4) Ждём, когда запуститься сервер. После успешного запуска сервера можем перейти к front.

## 4) Front(React):
#### 4.1) Входим внутрь и открываем папку "frontend". 
#### 4.2) Запускаем командную строку.
#### 4.3) Вводим '<i>npm install</i>' чтобы загрузить все транзитивные зависимости.
#### 4.4) Вводим '<i>npm start</i>' чтобы запустить проект.
#### 4.5) Ожидание... и открывается сайт.
