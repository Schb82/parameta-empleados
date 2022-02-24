# parameta-empleados

El siguiente proyecto cuenta con una BD MySql cuya configuracion debe contar con:

URL
Login
Password

Con todos los privilegios CRUD.

Script BD:

create database parameta;

show databases;

use parameta;

show tables;

CREATE USER 'parametauser' IDENTIFIED BY 'Abcd1234';

GRANT ALL PRIVILEGES ON parameta.* TO 'parametauser';

FLUSH PRIVILEGES;

CREATE TABLE IF NOT EXISTS employee (
id INTEGER(11) NOT NULL AUTO_INCREMENT COMMENT 'Clave primaria',
typedocument varchar(2) NOT NULL COMMENT 'tipo de documento',
numberdocument varchar(10) NOT NULL COMMENT 'numero de documento',
names varchar(100) NOT NULL COMMENT 'Nombre del empleado',
lastname varchar(100) NOT NULL COMMENT 'apellido del empleado',
jobtitle varchar(100) NOT NULL COMMENT 'cargo del empleado',
salary double NOT NULL COMMENT 'salario del empleado',
birthdate date NOT NULL COMMENT 'fecha de nacimiento del empleado',
startdate date NOT NULL COMMENT 'fecha de vinculacion del empleado',
PRIMARY KEY (id)
) COMMENT='tabla de empleados';

Drop table employee;
describe employee;




# parameta-empleados
