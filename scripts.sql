CREATE DATABASE librarymanagement
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

DROP TABLE book;

CREATE TABLE book(
	id SERIAL PRIMARY KEY,
	name VARCHAR (100) NOT NULL,
	createddate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updateddate TIMESTAMP
);

INSERT INTO book (name)
VALUES	('Tôi thấy hoa vàng trên cỏ xanh'),
		('Harry Potter và Hội Phượng Hoàng'),
		('Game of Thrones: A Song of Ice and Fire'),
		('Tắt đèn'),
		('Homo Sapiens'),
		('Ông lão đánh cá và con cá vàng'),
		('Twilight'),
		('Người Hobbit: Đại chiến năm cánh quân'),
		('Robinson ở đảo hoang'),
		('Clean Code');

SELECT id, name, createddate, updateddate
	FROM public.book;