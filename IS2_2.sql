/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     16/11/2019 22:44:45                          */
/*==============================================================*/


alter table ANIMALES
   drop constraint FK_ANIMALES_RELATIONS_TIPOS_DE;

alter table AREAS
   drop constraint FK_AREAS_RELATIONS_TIPO_ARE;

alter table CUIDADOS_ANIMALES
   drop constraint FK_CUIDADOS_X_SALIDA_INSUM_2;

alter table CUIDADOS_ANIMALES
   drop constraint FK_CUIDADOS_RELATIONS_ANIMALES;

alter table CUIDADOS_PLANTAS
   drop constraint FK_CUIDADOS_X_SALIDA_INSUM;

alter table CUIDADOS_PLANTAS
   drop constraint FK_CUIDADOS_RELATIONS_PLANTAS;

alter table DISTRIBUCIONES_ANIMALES
   drop constraint FK_DISTRIBU_X_AREAS;

alter table DISTRIBUCIONES_ANIMALES
   drop constraint FK_DISTRIBU_RELATIONS_ANIMALES;

alter table DISTRIBUCIONES_PLANTAS
   drop constraint FK_DISTRIBU_X_AREAS_2;

alter table DISTRIBUCIONES_PLANTAS
   drop constraint FK_DISTRIBU_RELATIONS_PLANTAS;

alter table ENTRADA_INSUMOS
   drop constraint FK_ENTRADA__RELATIONS_INSUMOS;

alter table INSUMOS
   drop constraint FK_INSUMOS_RELATIONS_TIPO_ADM;

alter table PLANTAS
   drop constraint FK_PLANTAS_RELATIONS_TIPOS_PL;

alter table PROCESAMIENTO_ANIMAL
   drop constraint FK_PROCESAM_RELATIONS_ANIMALES;

alter table PROCESAMIENTO_ANIMAL
   drop constraint FK_PROCESAM_X_PRODUCTO_2;

alter table PROCESAMIENTO_PLANTA
   drop constraint FK_PROCESAM_RELATIONS_PLANTAS;

alter table PROCESAMIENTO_PLANTA
   drop constraint FK_PROCESAM_X_PRODUCTO;

alter table SALIDA_INSUMOS
   drop constraint FK_SALIDA_I_RELATIONS_ENTRADA_;

alter table SALIDA_PRODUCTOS
   drop constraint FK_SALIDA_P_RELATIONS_PROCESAM;

alter table VENTAS
   drop constraint FK_VENTAS_RELATIONS_SALIDA_P;

alter table VENTAS
   drop constraint FK_VENTAS_RELATIONS_CLIENTES;

drop index RELATIONSHIP_4_FK;

drop table ANIMALES cascade constraints;

drop index RELATIONSHIP_1_FK;

drop table AREAS cascade constraints;

drop table CLIENTES cascade constraints;

drop index RELATIONSHIP_18_FK;

drop index RELATIONSHIP_15_FK;

drop table CUIDADOS_ANIMALES cascade constraints;

drop index RELATIONSHIP_17_FK;

drop index RELATIONSHIP_16_FK;

drop table CUIDADOS_PLANTAS cascade constraints;

drop index RELATIONSHIP_22_FK;

drop index RELATIONSHIP_21_FK;

drop table DISTRIBUCIONES_ANIMALES cascade constraints;

drop index RELATIONSHIP_20_FK;

drop index RELATIONSHIP_19_FK;

drop table DISTRIBUCIONES_PLANTAS cascade constraints;

drop index RELATIONSHIP_10_FK;

drop table ENTRADA_INSUMOS cascade constraints;

drop index RELATIONSHIP_2_FK;

drop table INSUMOS cascade constraints;

drop table LOGS cascade constraints;

drop index RELATIONSHIP_3_FK;

drop table PLANTAS cascade constraints;

drop index RELATIONSHIP_9_FK;

drop index RELATIONSHIP_7_FK;

drop table PROCESAMIENTO_ANIMAL cascade constraints;

drop index RELATIONSHIP_8_FK;

drop index RELATIONSHIP_6_FK;

drop table PROCESAMIENTO_PLANTA cascade constraints;

drop table PRODUCTOS cascade constraints;

drop index RELATIONSHIP_14_FK;

drop table SALIDA_INSUMOS cascade constraints;

drop index RELATIONSHIP_11_FK;

drop table SALIDA_PRODUCTOS cascade constraints;

drop table TIPOS_DE_ANIMALES cascade constraints;

drop table TIPOS_PLANTAS cascade constraints;

drop table TIPO_ADMINISTRACION_INSUMO cascade constraints;

drop table TIPO_AREA cascade constraints;

drop index RELATIONSHIP_13_FK;

drop index RELATIONSHIP_12_FK;

drop table VENTAS cascade constraints;

drop sequence S_CUIDADOS_ANIMALES;

drop sequence S_CUIDADOS_PLANTAS;

drop sequence S_ENTRADA_INSUMOS;

drop sequence S_SALIDA_INSUMOS;

drop sequence S_SALIDA_PRODUCTOS;

drop sequence S_TIPO_ADMINISTRACION_INSUMO;

create sequence S_CUIDADOS_ANIMALES;

create sequence S_CUIDADOS_PLANTAS;

create sequence S_ENTRADA_INSUMOS;

create sequence S_SALIDA_INSUMOS;

create sequence S_SALIDA_PRODUCTOS;

create sequence S_TIPO_ADMINISTRACION_INSUMO;

/*==============================================================*/
/* Table: ANIMALES                                              */
/*==============================================================*/
create table ANIMALES 
(
   ID_ANIMAL            VARCHAR2(10)         not null,
   NOMBRE_CIENTIFICO    VARCHAR2(20)         not null,
   NOMBRE_COMUN         VARCHAR2(20)         not null,
   PESO                 INTEGER              not null,
   LONGITUD_VETICAL     FLOAT                not null,
   LONGITUD_HORIZONTAL  FLOAT                not null,
   FECHA_NACIMIENTO     DATE                 not null,
   SEXO                 CHAR(1)              not null,
   constraint PK_ANIMALES primary key (ID_ANIMAL, NOMBRE_CIENTIFICO)
);

/*==============================================================*/
/* Index: RELATIONSHIP_4_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_4_FK on ANIMALES (
   NOMBRE_COMUN ASC,
   NOMBRE_CIENTIFICO ASC
);

/*==============================================================*/
/* Table: AREAS                                                 */
/*==============================================================*/
create table AREAS 
(
   NUMERO_AREA          INTEGER              not null,
   ID_TIPO_AREA         CHAR(4)              not null,
   AREA                 FLOAT                not null,
   CERCADO              SMALLINT             not null,
   TIPO_SUELO           VARCHAR2(20)         not null,
   AGUA                 SMALLINT             not null,
   DISPONIBLE           SMALLINT             not null,
   constraint PK_AREAS primary key (NUMERO_AREA, ID_TIPO_AREA)
);

/*==============================================================*/
/* Index: RELATIONSHIP_1_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_1_FK on AREAS (
   ID_TIPO_AREA ASC
);

/*==============================================================*/
/* Table: CLIENTES                                              */
/*==============================================================*/
create table CLIENTES 
(
   CEDULA               CHAR(10)             not null,
   NOMBRE               CHAR(10)             not null,
   APELLIDO             CHAR(10)             not null,
   TELEFONO             CHAR(15)             not null,
   constraint PK_CLIENTES primary key (CEDULA)
);

/*==============================================================*/
/* Table: CUIDADOS_ANIMALES                                     */
/*==============================================================*/
create table CUIDADOS_ANIMALES 
(
   ID_CUIDADO           NUMBER(6)            not null,
   ID_SALIDA_INSUMO     INTEGER              not null,
   ID_ANIMAL            VARCHAR2(10)         not null,
   NOMBRE_CIENTIFICO    VARCHAR2(20)         not null,
   DOCIFICACION         CLOB                 not null,
   constraint PK_CUIDADOS_ANIMALES primary key (ID_CUIDADO)
);

/*==============================================================*/
/* Index: RELATIONSHIP_15_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_15_FK on CUIDADOS_ANIMALES (
   ID_SALIDA_INSUMO ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_18_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_18_FK on CUIDADOS_ANIMALES (
   ID_ANIMAL ASC,
   NOMBRE_CIENTIFICO ASC
);

/*==============================================================*/
/* Table: CUIDADOS_PLANTAS                                      */
/*==============================================================*/
create table CUIDADOS_PLANTAS 
(
   ID_CUIDADO           NUMBER(6)            not null,
   ID_SALIDA_INSUMO     INTEGER              not null,
   ID_PLANTA            VARCHAR2(10)         not null,
   NOMBRE_CIENTIFICO    VARCHAR2(20)         not null,
   DOCIFICACION         CLOB                 not null,
   constraint PK_CUIDADOS_PLANTAS primary key (ID_CUIDADO)
);

/*==============================================================*/
/* Index: RELATIONSHIP_16_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_16_FK on CUIDADOS_PLANTAS (
   ID_SALIDA_INSUMO ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_17_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_17_FK on CUIDADOS_PLANTAS (
   ID_PLANTA ASC,
   NOMBRE_CIENTIFICO ASC
);

/*==============================================================*/
/* Table: DISTRIBUCIONES_ANIMALES                               */
/*==============================================================*/
create table DISTRIBUCIONES_ANIMALES 
(
   NUMERO_AREA          INTEGER              not null,
   ID_TIPO_AREA         CHAR(4)              not null,
   ID_ANIMAL            VARCHAR2(10)         not null,
   NOMBRE_CIENTIFICO    VARCHAR2(20)         not null,
   FECHA_ASIGNACION     DATE                 not null,
   FECHA_SALIDA         DATE                 not null,
   DESCRIPCION_USO      CLOB,
   constraint PK_DISTRIBUCIONES_ANIMALES primary key (NUMERO_AREA, ID_TIPO_AREA, ID_ANIMAL, NOMBRE_CIENTIFICO)
);

/*==============================================================*/
/* Index: RELATIONSHIP_21_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_21_FK on DISTRIBUCIONES_ANIMALES (
   NUMERO_AREA ASC,
   ID_TIPO_AREA ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_22_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_22_FK on DISTRIBUCIONES_ANIMALES (
   ID_ANIMAL ASC,
   NOMBRE_CIENTIFICO ASC
);

/*==============================================================*/
/* Table: DISTRIBUCIONES_PLANTAS                                */
/*==============================================================*/
create table DISTRIBUCIONES_PLANTAS 
(
   NUMERO_AREA          INTEGER              not null,
   ID_TIPO_AREA         CHAR(4)              not null,
   ID_PLANTA            VARCHAR2(10)         not null,
   NOMBRE_CIENTIFICO    VARCHAR2(20)         not null,
   FECHA_ASIGNACION     DATE                 not null,
   FECHA_SALIDA         DATE                 not null,
   DESCRIPCION_USO      CLOB,
   constraint PK_DISTRIBUCIONES_PLANTAS primary key (NUMERO_AREA, ID_TIPO_AREA, ID_PLANTA, NOMBRE_CIENTIFICO)
);

/*==============================================================*/
/* Index: RELATIONSHIP_19_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_19_FK on DISTRIBUCIONES_PLANTAS (
   NUMERO_AREA ASC,
   ID_TIPO_AREA ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_20_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_20_FK on DISTRIBUCIONES_PLANTAS (
   ID_PLANTA ASC,
   NOMBRE_CIENTIFICO ASC
);

/*==============================================================*/
/* Table: ENTRADA_INSUMOS                                       */
/*==============================================================*/
create table ENTRADA_INSUMOS 
(
   ID_COMPRA_INSUMO     NUMBER(6)            not null,
   COD_INSUMO           VARCHAR2(10)         not null,
   FECHA_COMPRA         DATE                 not null,
   CANTIDAD             DATE                 not null,
   FECHA_CADUCIDAD      DATE                 not null,
   constraint PK_ENTRADA_INSUMOS primary key (ID_COMPRA_INSUMO)
);

/*==============================================================*/
/* Index: RELATIONSHIP_10_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_10_FK on ENTRADA_INSUMOS (
   COD_INSUMO ASC
);

/*==============================================================*/
/* Table: INSUMOS                                               */
/*==============================================================*/
create table INSUMOS 
(
   COD_INSUMO           VARCHAR2(10)         not null,
   ID_ADM_PROD          INTEGER              not null,
   NOMBRE               VARCHAR2(20)         not null,
   DESCRIPCION          CLOB,
   constraint PK_INSUMOS primary key (COD_INSUMO)
);

/*==============================================================*/
/* Index: RELATIONSHIP_2_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_2_FK on INSUMOS (
   ID_ADM_PROD ASC
);

/*==============================================================*/
/* Table: LOGS                                                  */
/*==============================================================*/
create table LOGS 
(
   TABLA                CHAR(20)             not null,
   DATOSINICIALES       CHAR(20),
   OPERACION            CHAR(20),
   DATOSFINALES         CHAR(20),
   FECHA                DATE                 not null,
   USUARIO              CHAR(20),
   ID_LOG               NUMBER(6)            not null,
   constraint PK_LOGS primary key (ID_LOG)
);

/*==============================================================*/
/* Table: PLANTAS                                               */
/*==============================================================*/
create table PLANTAS 
(
   ID_PLANTA            VARCHAR2(10)         not null,
   NOMBRE_CIENTIFICO    VARCHAR2(20)         not null,
   NOMBRE_COMUN         VARCHAR2(20)         not null,
   FECHA_PLANTACION     DATE                 not null,
   OBSERVACION          CLOB,
   constraint PK_PLANTAS primary key (ID_PLANTA, NOMBRE_CIENTIFICO)
);

/*==============================================================*/
/* Index: RELATIONSHIP_3_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_3_FK on PLANTAS (
   NOMBRE_CIENTIFICO ASC,
   NOMBRE_COMUN ASC
);

/*==============================================================*/
/* Table: PROCESAMIENTO_ANIMAL                                  */
/*==============================================================*/
create table PROCESAMIENTO_ANIMAL 
(
   NUMERO_PROCESAMIENTO INTEGER              not null,
   FECHA                DATE                 not null,
   ID_ANIMAL            VARCHAR2(10)         not null,
   NOMBRE_CIENTIFICO    VARCHAR2(20)         not null,
   COD_PRODUCTO         VARCHAR2(10)         not null,
   MORTAL               SMALLINT             not null,
   FECHA_CADUCIDAD      DATE                 not null,
   constraint PK_PROCESAMIENTO_ANIMAL primary key (NUMERO_PROCESAMIENTO, FECHA, COD_PRODUCTO)
);

/*==============================================================*/
/* Index: RELATIONSHIP_7_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_7_FK on PROCESAMIENTO_ANIMAL (
   ID_ANIMAL ASC,
   NOMBRE_CIENTIFICO ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_9_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_9_FK on PROCESAMIENTO_ANIMAL (
   COD_PRODUCTO ASC
);

/*==============================================================*/
/* Table: PROCESAMIENTO_PLANTA                                  */
/*==============================================================*/
create table PROCESAMIENTO_PLANTA 
(
   NUMERO_PROCESAMIENTO INTEGER              not null,
   FECHA                DATE                 not null,
   ID_PLANTA            VARCHAR2(10)         not null,
   NOMBRE_CIENTIFICO    VARCHAR2(20)         not null,
   COD_PRODUCTO         VARCHAR2(10)         not null,
   MORTAL               SMALLINT             not null,
   CANTIDAD             FLOAT                not null,
   UNIDAD               VARCHAR2(5)          not null,
   FECHA_CADUCIDAD      DATE                 not null,
   constraint PK_PROCESAMIENTO_PLANTA primary key (NUMERO_PROCESAMIENTO, FECHA, COD_PRODUCTO)
);

/*==============================================================*/
/* Index: RELATIONSHIP_6_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_6_FK on PROCESAMIENTO_PLANTA (
   ID_PLANTA ASC,
   NOMBRE_CIENTIFICO ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_8_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_8_FK on PROCESAMIENTO_PLANTA (
   COD_PRODUCTO ASC
);

/*==============================================================*/
/* Table: PRODUCTOS                                             */
/*==============================================================*/
create table PRODUCTOS 
(
   COD_PRODUCTO         VARCHAR2(10)         not null,
   NOMBRE               VARCHAR2(20)         not null,
   PESO                 INTEGER              not null,
   DESCRIPCION          CLOB,
   constraint PK_PRODUCTOS primary key (COD_PRODUCTO)
);

/*==============================================================*/
/* Table: SALIDA_INSUMOS                                        */
/*==============================================================*/
create table SALIDA_INSUMOS 
(
   ID_SALIDA_INSUMO     NUMBER(6)            not null,
   ID_COMPRA_INSUMO     INTEGER              not null,
   CANTIDAD             INTEGER              not null,
   FECHA_SALIDA         DATE                 not null,
   constraint PK_SALIDA_INSUMOS primary key (ID_SALIDA_INSUMO)
);

/*==============================================================*/
/* Index: RELATIONSHIP_14_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_14_FK on SALIDA_INSUMOS (
   ID_COMPRA_INSUMO ASC
);

/*==============================================================*/
/* Table: SALIDA_PRODUCTOS                                      */
/*==============================================================*/
create table SALIDA_PRODUCTOS 
(
   ID_SALIDA_PROD       NUMBER(6)            not null,
   NUMERO_PROCESAMIENTO INTEGER              not null,
   FECHA                DATE,
   COD_PRODUCTO         VARCHAR2(10),
   CANTIDAD             INTEGER              not null,
   FECHA_SALIDA         DATE                 not null,
   constraint PK_SALIDA_PRODUCTOS primary key (ID_SALIDA_PROD)
);

/*==============================================================*/
/* Index: RELATIONSHIP_11_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_11_FK on SALIDA_PRODUCTOS (
   NUMERO_PROCESAMIENTO ASC,
   FECHA ASC,
   COD_PRODUCTO ASC
);

/*==============================================================*/
/* Table: TIPOS_DE_ANIMALES                                     */
/*==============================================================*/
create table TIPOS_DE_ANIMALES 
(
   NOMBRE_CIENTIFICO    VARCHAR2(20)         not null,
   NOMBRE_COMUN         VARCHAR2(20)         not null,
   RAZA                 VARCHAR2(20)         not null,
   DESCRIPCION          CLOB                 not null,
   constraint PK_TIPOS_DE_ANIMALES primary key (NOMBRE_COMUN, NOMBRE_CIENTIFICO)
);

/*==============================================================*/
/* Table: TIPOS_PLANTAS                                         */
/*==============================================================*/
create table TIPOS_PLANTAS 
(
   NOMBRE_CIENTIFICO    VARCHAR2(20)         not null,
   NOMBRE_COMUN         VARCHAR2(20)         not null,
   DIAS_PARA_COSECHA    INTEGER              not null,
   DESCRIPCION          CLOB                 not null,
   constraint PK_TIPOS_PLANTAS primary key (NOMBRE_CIENTIFICO, NOMBRE_COMUN)
);

/*==============================================================*/
/* Table: TIPO_ADMINISTRACION_INSUMO                            */
/*==============================================================*/
create table TIPO_ADMINISTRACION_INSUMO 
(
   ID_ADM_PROD          NUMBER(6)            not null,
   NOMBRE               VARCHAR2(15)         not null,
   constraint PK_TIPO_ADMINISTRACION_INSUMO primary key (ID_ADM_PROD)
);

/*==============================================================*/
/* Table: TIPO_AREA                                             */
/*==============================================================*/
create table TIPO_AREA 
(
   ID_TIPO_AREA         CHAR(4)              not null,
   NOMBRE_AREA          VARCHAR2(20)         not null,
   constraint PK_TIPO_AREA primary key (ID_TIPO_AREA)
);

/*==============================================================*/
/* Table: VENTAS                                                */
/*==============================================================*/
create table VENTAS 
(
   ID_FACTURA           CHAR(9)              not null,
   ID_SALIDA_PROD       INTEGER              not null,
   CEDULA               CHAR(10)             not null,
   constraint PK_VENTAS primary key (ID_FACTURA, ID_SALIDA_PROD, CEDULA)
);

/*==============================================================*/
/* Index: RELATIONSHIP_12_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_12_FK on VENTAS (
   ID_SALIDA_PROD ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_13_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_13_FK on VENTAS (
   CEDULA ASC
);

alter table ANIMALES
   add constraint FK_ANIMALES_RELATIONS_TIPOS_DE foreign key (NOMBRE_COMUN, NOMBRE_CIENTIFICO)
      references TIPOS_DE_ANIMALES (NOMBRE_COMUN, NOMBRE_CIENTIFICO);

alter table AREAS
   add constraint FK_AREAS_RELATIONS_TIPO_ARE foreign key (ID_TIPO_AREA)
      references TIPO_AREA (ID_TIPO_AREA);

alter table CUIDADOS_ANIMALES
   add constraint FK_CUIDADOS_X_SALIDA_INSUM_2 foreign key (ID_SALIDA_INSUMO)
      references SALIDA_INSUMOS (ID_SALIDA_INSUMO);

alter table CUIDADOS_ANIMALES
   add constraint FK_CUIDADOS_RELATIONS_ANIMALES foreign key (ID_ANIMAL, NOMBRE_CIENTIFICO)
      references ANIMALES (ID_ANIMAL, NOMBRE_CIENTIFICO);

alter table CUIDADOS_PLANTAS
   add constraint FK_CUIDADOS_X_SALIDA_INSUM foreign key (ID_SALIDA_INSUMO)
      references SALIDA_INSUMOS (ID_SALIDA_INSUMO);

alter table CUIDADOS_PLANTAS
   add constraint FK_CUIDADOS_RELATIONS_PLANTAS foreign key (ID_PLANTA, NOMBRE_CIENTIFICO)
      references PLANTAS (ID_PLANTA, NOMBRE_CIENTIFICO);

alter table DISTRIBUCIONES_ANIMALES
   add constraint FK_DISTRIBU_X_AREAS foreign key (NUMERO_AREA, ID_TIPO_AREA)
      references AREAS (NUMERO_AREA, ID_TIPO_AREA);

alter table DISTRIBUCIONES_ANIMALES
   add constraint FK_DISTRIBU_RELATIONS_ANIMALES foreign key (ID_ANIMAL, NOMBRE_CIENTIFICO)
      references ANIMALES (ID_ANIMAL, NOMBRE_CIENTIFICO);

alter table DISTRIBUCIONES_PLANTAS
   add constraint FK_DISTRIBU_X_AREAS_2 foreign key (NUMERO_AREA, ID_TIPO_AREA)
      references AREAS (NUMERO_AREA, ID_TIPO_AREA);

alter table DISTRIBUCIONES_PLANTAS
   add constraint FK_DISTRIBU_RELATIONS_PLANTAS foreign key (ID_PLANTA, NOMBRE_CIENTIFICO)
      references PLANTAS (ID_PLANTA, NOMBRE_CIENTIFICO);

alter table ENTRADA_INSUMOS
   add constraint FK_ENTRADA__RELATIONS_INSUMOS foreign key (COD_INSUMO)
      references INSUMOS (COD_INSUMO);

alter table INSUMOS
   add constraint FK_INSUMOS_RELATIONS_TIPO_ADM foreign key (ID_ADM_PROD)
      references TIPO_ADMINISTRACION_INSUMO (ID_ADM_PROD);

alter table PLANTAS
   add constraint FK_PLANTAS_RELATIONS_TIPOS_PL foreign key (NOMBRE_CIENTIFICO, NOMBRE_COMUN)
      references TIPOS_PLANTAS (NOMBRE_CIENTIFICO, NOMBRE_COMUN);

alter table PROCESAMIENTO_ANIMAL
   add constraint FK_PROCESAM_RELATIONS_ANIMALES foreign key (ID_ANIMAL, NOMBRE_CIENTIFICO)
      references ANIMALES (ID_ANIMAL, NOMBRE_CIENTIFICO);

alter table PROCESAMIENTO_ANIMAL
   add constraint FK_PROCESAM_X_PRODUCTO_2 foreign key (COD_PRODUCTO)
      references PRODUCTOS (COD_PRODUCTO);

alter table PROCESAMIENTO_PLANTA
   add constraint FK_PROCESAM_RELATIONS_PLANTAS foreign key (ID_PLANTA, NOMBRE_CIENTIFICO)
      references PLANTAS (ID_PLANTA, NOMBRE_CIENTIFICO);

alter table PROCESAMIENTO_PLANTA
   add constraint FK_PROCESAM_X_PRODUCTO foreign key (COD_PRODUCTO)
      references PRODUCTOS (COD_PRODUCTO);

alter table SALIDA_INSUMOS
   add constraint FK_SALIDA_I_RELATIONS_ENTRADA_ foreign key (ID_COMPRA_INSUMO)
      references ENTRADA_INSUMOS (ID_COMPRA_INSUMO);

alter table SALIDA_PRODUCTOS
   add constraint FK_SALIDA_P_RELATIONS_PROCESAM foreign key (NUMERO_PROCESAMIENTO, FECHA, COD_PRODUCTO)
      references PROCESAMIENTO_ANIMAL (NUMERO_PROCESAMIENTO, FECHA, COD_PRODUCTO);

alter table VENTAS
   add constraint FK_VENTAS_RELATIONS_SALIDA_P foreign key (ID_SALIDA_PROD)
      references SALIDA_PRODUCTOS (ID_SALIDA_PROD);

alter table VENTAS
   add constraint FK_VENTAS_RELATIONS_CLIENTES foreign key (CEDULA)
      references CLIENTES (CEDULA);

