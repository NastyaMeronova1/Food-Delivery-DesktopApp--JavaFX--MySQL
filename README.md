# Food Delivery DesktopApp, JavaFX, MySQL
 
<h3 align="center">Приложение на тему "Доставка еды". JavaFX, MySQL.</h3>

	Тема: Доставка еды
	Язык программирования: Java
	Фреймворк: JavaFX
	Базы данных: MySQL(заполнение прикреплю ниже)
	Java 19.0
	Для работы нужен JDBC(MySQL Connector)

<h4 align="center">Скриншоты:</h4>
<h5>Окно "Главное меню"</h5>
<img width="382" alt="image" src="https://user-images.githubusercontent.com/90754791/210662891-e24a2064-1b26-48cb-a6fc-cc1c4d8d448f.png">
<h5>Окно "Авторизация"</h5>
<img width="328" alt="image" src="https://user-images.githubusercontent.com/90754791/210662965-7d73aa56-31ee-4959-ada3-b6869b0d0164.png">
<h5>Окно "Регистрация"</h5>
<img width="400" alt="image" src="https://user-images.githubusercontent.com/90754791/210663111-7e8ef355-f778-478f-8acb-0f1033f774c0.png">
<h5>Окно пользователя "Выбор категории"</h5>
<img width="605" alt="image" src="https://user-images.githubusercontent.com/90754791/210664562-a7419030-6e6f-4330-9260-354dea773bc6.png">
<h5>Окно пользователя "Горячие блюда"</h5>
Может быть заполнено другим содержимым, в зависимости от выбранной категории
<img width="603" alt="image" src="https://user-images.githubusercontent.com/90754791/210664749-db19d91c-56af-45c4-a744-23e559917135.png">
<h5>Окно "Просмотр статуса заказа"</h5>
<img width="604" alt="image" src="https://user-images.githubusercontent.com/90754791/210662937-980702f0-e166-41cb-baf0-237b9eb2fb5f.png">
<h5>Окно администратора "База данных аккаунтов"</h5>
<img width="583" alt="image" src="https://user-images.githubusercontent.com/90754791/210663185-50643ede-bcf5-47c9-8416-57d0a1139a7c.png">
<h5>Окно работника "База данных заказов"</h5>
<img width="829" alt="image" src="https://user-images.githubusercontent.com/90754791/210663282-562bfe51-ba32-4230-aeff-241b3732bd5b.png">

<h3>Базы данных:</h3>
Название таблицы: food_delivery

Table: user

	Columns:
	iduser int AI PK 
	login varchar(45) 
	password varchar(255) 
	name varchar(45) 
	role varchar(45)

Table: request

	Columns:
	idrequest int AI PK 
	name varchar(255) 
	telephone_number varchar(255) 
	description varchar(255) 
	summ text 
	status varchar(45)

Table: dish

	Columns:
	iddish int AI PK 
	title varchar(255) 
	name_1 varchar(255) 
	name_2 varchar(255) 
	name_3 varchar(255) 
	name_4 varchar(255) 
	name_5 varchar(255) 
	name_6 varchar(255) 
	price_1 int 
	price_2 int 
	price_3 int 
	price_4 int 
	price_5 int 
	price_6 int 
	image_1 varchar(255) 
	image_2 varchar(255) 
	image_3 varchar(255) 
	image_4 varchar(255) 
	image_5 varchar(255) 
	image_6 varchar(255)

Приложение ещё будет дорабатываться!
