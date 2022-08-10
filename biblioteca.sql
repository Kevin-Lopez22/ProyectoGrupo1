-- base de datos para biblioteca
use master 
go

create database baseBiblioteca
go

use baseBiblioteca 
go

DROP DATABASE baseBiblioteca

/*creacion tablas*/

/*==============================================================*/
/* Table: LIBRO                                                 */
/*==============================================================*/
create table LIBRO (
   IDLIBRO          char(10)                  not null,
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
   IDEJEMPLAR          int                  not null,
   ESTADO         char(50)             not null,
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
   DIRECCION            char(8)              not null,
   TELEFONO             char(10)             not null,
   CORREO               varchar(100)         null
   constraint PK_CLIENTES primary key nonclustered (CICLIENTE)
)



/*==============================================================*/
/* Table: BIBLIOTECARIO                                              */
/*==============================================================*/
create table BIBLIOTECARIOS (
   IDBIBLIOTECARIO      char(10)             not null,
   CONTRASENIA          char(10)             not null,
   HoraEntrada          time                 not null,
   HoraSalida           time                 not null,
   CIBIBLIOTECARIO      char(10)             not null,
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

