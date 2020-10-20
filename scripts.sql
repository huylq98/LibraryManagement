CREATE DATABASE librarymanagement
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

DROP TABLE book;
DROP TABLE category;

/*----------
* Create table
*----------
*/
CREATE TABLE category(
	id SERIAL PRIMARY KEY,
	name VARCHAR(100),
	createddate DATE DEFAULT CURRENT_DATE,
	updateddate DATE
);

CREATE TABLE book(
	id SERIAL PRIMARY KEY,
	name VARCHAR (100),
	author VARCHAR (50),
	content TEXT,
	releaseddate DATE,
	createddate DATE DEFAULT CURRENT_DATE,
	updateddate DATE,
	categoryid INTEGER,
	FOREIGN KEY (categoryid) REFERENCES category(id)
);

/*----------
* Insert values
*----------
*/
INSERT INTO category(name)
VALUES 	('Khoa học viễn tưởng'),
		('Văn học hiện đại'),
		('Tiểu thuyết'),
		('Khoa học');

INSERT INTO book (name, author, content, categoryid)
VALUES	('Tôi thấy hoa vàng trên cỏ xanh', 'Nguyễn Nhật Ánh', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2'),
		('Harry Potter', 'J.K. Rowling', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '3'),
		('Game of Thrones: A Song of Ice and Fire', 'George R.R. Martin', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2'),
		('Tắt đèn', 'Ngô Tất Tố', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '3'),
		('Homo Sapiens: A Brief History of Humankind', 'Yuval Noah Harari', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '1'),
		('Ông lão đánh cá và con cá vàng', 'Alexander Pushkin', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '4'),
		('Twilight', 'Stephenie Meyer', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '1'),
		('The Hobbit', 'J. R. R. Tolkien', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '4'),
		('Robinson Crusoe', 'Daniel Defoe', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2'),
		('Clean Code: A Handbook of Agile Software Craftsmanship', 'Robert C. Martin', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '1');

SELECT * FROM category;
SELECT * FROM book;