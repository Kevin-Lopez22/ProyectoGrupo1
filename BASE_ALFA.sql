-- base de datos para biblioteca
use master 
go

drop database baseBiblioteca;
create database baseBiblioteca
go

use baseBiblioteca 
go


--drop table libro
/*creacion tablas*/

/*==============================================================*/
/* Table: LIBRO                                                 */
/*==============================================================*/
create table LIBRO (
   IDLIBRO              char(10)                  not null,
   TITULO               char(100)             not null,
   ISBN                 char(30)             null,
   AUTOR                char(100)            not null,
   STOCK                int                  not null,
   PAGINAS              int                  not null
   constraint PK_LIBRO primary key nonclustered (IDLIBRO)
)
go
/*==============================================================*/
/* Table: EJEMPLARES                                            */
/*==============================================================*/
create table EJEMPLARES (
   IDLIBRO          CHAR(10)                  not null,
   IDEJEMPLAR        int identity(1,1)                 not null,
   ESTADO            char(50) DEFAULT 'Disponible'               not null,
   constraint PK_EJEMPLARES primary key nonclustered (IDLIBRO, IDEJEMPLAR)
)
go
/*==============================================================*/
/* Index: RELATIONSHIP_2_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_2_FK on EJEMPLARES (
IDLIBRO ASC
)
go
/*==============================================================*/
/* Table: PRESTAMO                                              */
/*==============================================================*/
create table PRESTAMO (
   CODIGOCLIENTE        CHAR(10)                  not null,
   CODIGOLIBRO          CHAR(10)                 not null,
   CODEJEMPLAR          int                  not null,
   FECHAPRESTAMO        datetime             not null,
   FECHADEVOLUCION      datetime             not null,
   constraint PK_PRESTAMO primary key nonclustered (CODIGOCLIENTE, CODIGOLIBRO, CODEJEMPLAR)
)
go

go
/*==============================================================*/
/* Table: CLIENTES                                              */
/*==============================================================*/
create table CLIENTES (
   IDCLIENTE            char(10)             not null,
   CICLIENTE            char(10)             not null,
   NOMBRECLIENTE        char(30)             not null,
   APELLIDOCLIENTE      char(30)             not null,
   DIRECCION            varchar(30)          not null,
   TELEFONO             char(20)             not null,
   CORREO               varchar(100)         null,
   SUSPENDIDO           bit                  not null
   constraint PK_CLIENTES primary key nonclustered (CICLIENTE)
)
go



/*==============================================================*/
/* Table: BIBLIOTECARIO                                              */
/*==============================================================*/
create table BIBLIOTECARIO (
   CIBIBLIOTECARIO      char(10)             not null,
   CONTRASENIA          char(10)             not null,
   NOMBREBIBLIOTECARIO        char(30)             not null,
   APELLIDOBIBLIOTECARIO      char(30)             not null,
   DIRECCIONBIBLIOTECARIO            char(8)              not null,
   TELEFONOBIBLIOTECARIO             char(10)             not null,
   CORREOBIBLIOTECARIO               varchar(100)         null
   constraint PK_BIBLIOTECARIOS primary key nonclustered (CIBIBLIOTECARIO)
)


/*==============================================================*/
/* Index: RELATIONSHIP_3_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_3_FK on PRESTAMO (
CODIGOCLIENTE ASC
)
go

/*==============================================================*/
/* Index: RELATIONSHIP_4_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_4_FK on PRESTAMO (
CODIGOLIBRO ASC,
CODEJEMPLAR ASC
)
go


alter table EJEMPLARES
   add constraint FK_EJEMPLAR_RELATIONS_LIBRO foreign key (IDLIBRO)
      references LIBRO (IDLIBRO)
go

alter table PRESTAMO
   add constraint FK_PRESTAMO_RELATIONS_CLIENTES foreign key (CODIGOCLIENTE)
      references CLIENTES (CICLIENTE)
go

alter table PRESTAMO
   add constraint FK_PRESTAMO_RELATIONS_EJEMPLAR foreign key (CODIGOLIBRO, CODEJEMPLAR)
      references EJEMPLARES (IDLIBRO, IDEJEMPLAR)
go

--CASCADE TABLA EJEMPLAR
ALTER TABLE [dbo].[EJEMPLARES]  WITH CHECK ADD  CONSTRAINT [FK_LIBRO_EJEMPLAR] FOREIGN KEY([IDLIBRO])
REFERENCES [dbo].[LIBRO] ([IDLIBRO])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

--UNIQUE ISBN
ALTER TABLE Libro
ADD CONSTRAINT ISBN_Unique UNIQUE (ISBN); 
GO


--TRIGGERS

--TABLA EJEMPLAR

--trigger insertar
CREATE TRIGGER TR_EJEMPLAR1
ON EJEMPLARES
for insert
as
BEGIN
DECLARE @idLibro varchar(10)

select @idLibro = IDLIBRO
from inserted
 
Update LIBRO
SET STOCK = STOCK + 1
WHERE IDLIBRO = @idLibro

END
GO



--trigger eliminar ejemplar
CREATE TRIGGER TR_EJEMPLAR2
ON EJEMPLARES
for delete
as
BEGIN
DECLARE @idLibro varchar(10)

select @idLibro = IDLIBRO
from deleted
 
Update LIBRO
SET STOCK = STOCK - 1
WHERE IDLIBRO = @idLibro

END
GO

--STORED PROCEDURES



CREATE PROCEDURE insertarLibro
@idLibro char(10),@titulo char(100), @isbn char(30), @autor char(100), @stock int, @paginas int
as begin
insert into LIBRO (IDLIBRO,TITULO,ISBN,AUTOR,STOCK,PAGINAS) 
values (@idlibro,@titulo,@isbn,@autor,@stock,@paginas)
end
go


CREATE PROCEDURE eliminarLibro
@idlibro char(100)
as begin
delete from LIBRO where IDLIBRO = @idlibro
end
go

CREATE PROCEDURE insertarEjemplar
@idlibro char(10), @estado char(50)
as begin
insert into EJEMPLARES(IDLIBRO, ESTADO) 
values (@idlibro,@estado)
end
go


CREATE PROCEDURE eliminarEjemplar
@idejemplar char(100)
as begin
delete from EJEMPLARES where IDEJEMPLAR = @idejemplar
end
go

