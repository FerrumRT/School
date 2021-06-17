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


## 2) Backend
#### 2.1) Входим внутрь и открываем папку "backend". 
#### 2.2) Открываем проект на редакторе(например IntellijIdea(использую я) или другие.) и ждем сборки проекта.
#### 2.3) После сборки проекта заходим в папку src -> main -> java -> kz.school.School -> открываем файл SchoolApplication и запускаем этот файл(этот файл запускает проект)
#### 2.4) Ждём, когда запуститься сервер. После успешного запуска сервера можем перейти к front.

## 3) Front(React):
#### 3.1) Входим внутрь и открываем папку "frontend". 
#### 3.2) Запускаем командную строку.
#### 3.3) Вводим '<i>npm install</i>' чтобы загрузить все транзитивные зависимости.
#### 3.4) Вводим '<i>npm start</i>' чтобы запустить проект.

## ** Все данные хранятся в базе данных. База находится в хосте, и эта база находится далеко от нашей местоположении, так как хост находится далеко данные может задержатся на 2-3-4сек для загрузки. Для каждого запроса от базы и для представление уходят максимум 3-4сек. **
