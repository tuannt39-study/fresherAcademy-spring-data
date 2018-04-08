--------------------------------------------------------
--  File created - Sunday-April-08-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table STUDENT
--------------------------------------------------------

  CREATE TABLE "ITSOL"."STUDENT" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(20 BYTE), 
	"LOCATION" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into ITSOL.STUDENT
SET DEFINE OFF;
Insert into ITSOL.STUDENT (ID,NAME,LOCATION) values (1,'tuan1','ha noi1');
