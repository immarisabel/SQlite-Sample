# SQlite Sample
 _base template to use SQlite_
JDK 14

## QUERIES GUIDE

### main command
_statement.executeUpdate_

### create table
_create table tableName (id integer PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, name string, score integer)_

### insert data
_insert into tableName values(1, 'name', 40)_
- 1 = id
- name = name
- 40 = score

### delete data
_DELETE FROM tableName WHERE id = 1_

## display data
### full table
_SELECT * FROM tableName_
### max value
_SELECT * FROM tableName WHERE score = (SELECT MAX(score) FROM tableName)_

