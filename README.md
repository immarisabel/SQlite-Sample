# SQlite Sample
 *base template to use SQlite*
JDK 14

## QUERIES GUIDE

### main command
*statement.executeUpdate*

### create table
*create table tableName (id integer PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, name string, score integer)*
### insert data
*insert into tableName values(1, 'name', 40)*
- 1 = id
- name = name
- 40 = score

### delete data
*DELETE FROM tableName WHERE id = 1*

## display data
### full table
*SELECT * FROM tableName*
### max value
*SELECT * FROM tableName WHERE score = (SELECT MAX(score) FROM tableName)*

