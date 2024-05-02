# YouTube_Shorts_Video_Editing
Youtube shorts quizzes video editing using Web and Java backend

Using a front end of HTML CSS and Javascript
Database of SQL
and Backend of Java

Ill make a video editing program to automate video editing of my youtube videos.


Frontend
Public -
this is where all of the files that dont need to be compiled or processed go, like html and images

Src - 
this is where all my code and styling files go that need to be compiled and processed first.


Video Editing
Audio - Xuggle (based on FFmpeg) or JCodec
Video - 
Text - AWT and Swing

Use BufferedImage and ImageIO to store images and render each out individually into png frames




# How to use the MariaDB Server

'''connect to the mariadb'''
~sudo mariadb -u root

'''Exit mariadb (run while mariadb is running)'''
~EXIT;

# Here on out these are sql commands once mariadb is running
'''Show the databases'''
~SHOW DATABASES;

'''Select/use a database'''
~USE {database name};

'''Create a database'''
~CREATE DATABASE {database name};

'''Delete a database'''
~DROP DATABASE {database name};


'''Create a table'''
~CREATE TABLE {table name} (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT
);

'''Insert data into a table'''
~INSERT INTO {table name} ({element1}, {element2}, ...) VALUES ({element1 value}, {element2 value}, ...);
~INSERT INTO example (name, age) VALUES ('John Doe', 30);
~INSERT INTO example (name, age) VALUES ('Jane Smith', 25);

'''Get data from a table'''
selects the whole table and everything in it
~SELECT * FROM {table name};

selects just the name and age columns
~SELECT name, age FROM example;

this will grab all rows which have an age of greater than 10
~SELECT * FROM example WHERE age > 10;

this will grab all names where the age is greater than 10
~SELECT name FROM example WHERE age > 10;

this will grab all id and name where age is greater than 10
~SELECT id, name FROM example WHERE age > 10;

you can chain ifs together
~SELECT * FROM example WHERE age > 10 AND name < 100;
~SELECT * FROM example WHERE age > 10 OR name = 'John Doe;

you can use a range statement 
~SELECT * FROM example WHERE age BETWEEN 25 AND 35;

only grab rows that contain these elements
~SELECT * FROM example WHERE name IN ('John Doe', 'Jane Smith');

use the like keyword to not exactly search
% will match an unlimited amount of characters
_ will only match for one character
~SELECT * FROM example WHERE name LIKE 'J%';
~SELECT * FROM example WHERE name LIKE '_ane Smith';

order the results in some way
SELECT * FROM example WHERE age > 25 ORDER BY age DESC;

in this case there is 2 sorting criteria. so if there is 2 of the same name it will then sort by age
SELECT name, age FROM example ORDER BY name ASC, age DESC;

math operations on the tables
returns the count of all of the rows 
SELECT COUNT(*) FROM example;

from the rows returned it will average the age
SELECT AVG(age) FROM example;

from the rows returned it will return the max age
SELECT MAX(age) FROM example WHERE name LIKE 'J%';
