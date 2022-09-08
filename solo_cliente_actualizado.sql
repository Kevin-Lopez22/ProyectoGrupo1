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