create database [StarTrust]
on primary
(
	Name = 'STrustDB',
	FileName = 'C:\Users\User\Desktop\JV SCRIPT\JavaPractice\New folder\Javascript\Java Project\Niit Java Project\MY DATABASE\STrustDB.mdf',
	Size = 500MB,
	MaxSize = 2GB,
	Filegrowth = 100MB
)
Log on
(
	Name = 'STrustDB_LOG',
	FileName = 'C:\Users\User\Desktop\JV SCRIPT\JavaPractice\New folder\Javascript\Java Project\Niit Java Project\MY DATABASESTrustDB_LOG.ldf',
	Size = 10MB,
	MaxSize = 1GB,
	Filegrowth = 10MB
)

use StarTrust

create table Login
(
	ID int identity(1,1) Primary Key,
	UserName varchar(100) not null,
	Password varchar(100) not null
)
insert into Login values('Admin','12345')

select * from Login