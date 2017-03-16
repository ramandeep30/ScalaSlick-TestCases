DROP TABLE IF EXISTS Employee;

CREATE TABLE IF NOT EXISTS Employee(id int PRIMARY KEY ,name varchar(200),experience double);

DROP TABLE IF EXISTS Project;

CREATE TABLE IF NOT EXISTS Project (
  id int PRIMARY KEY,
  name varchar(25),
  empId INT NOT NULL references Employee(id),
  totalMembers int,
  lead varchar(30)
  );

DROP TABLE IF EXISTS Dependent;

CREATE TABLE IF NOT EXISTS Dependent (
  dependentid int PRIMARY KEY,
  empId int NOT NULL references Employee(id),
  name varchar(50),
  relation varchar(20),
  age int
  );
