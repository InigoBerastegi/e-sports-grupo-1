/* CREACION DE TABLAS TABLAS */
DROP TABLE COMPETICION CASCADE CONSTRAINTS;
DROP TABLE JUEGO CASCADE CONSTRAINTS;
DROP TABLE JORNADA CASCADE CONSTRAINTS;
DROP TABLE ENFRENTAMIENTO;
DROP TABLE EQUIPO CASCADE CONSTRAINTS;
DROP TABLE PATROCINADOR CASCADE CONSTRAINTS;
DROP TABLE USUARIO CASCADE CONSTRAINTS;
DROP TABLE JUGADOR CASCADE CONSTRAINTS;
DROP TABLE ENTRENADOR CASCADE CONSTRAINTS;
DROP TABLE ASISTENTE CASCADE CONSTRAINTS;

CREATE TABLE JUEGO(
    ID_JUEGO NUMBER(3) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    NOMBRE VARCHAR2(30) not null,
    EMPRESA VARCHAR2(30) not null,
    FECHA_LANZAMIENTO DATE,
    CONSTRAINT PK_JUEGO PRIMARY KEY (ID_JUEGO)
);
CREATE TABLE COMPETICION(
    ID_COMPETICION NUMBER(3) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    NOMBRE VARCHAR(40) not null,
    FECHA_INICIO DATE not null,
    FECHA_FIN DATE not null,
    ESTADO VARCHAR2(20) CHECK (ESTADO IN ('abierto', 'cerrado')) not null,
    ID_JUEGO NUMBER(3),
    CONSTRAINT PK_COMPETICION PRIMARY KEY (ID_COMPETICION),
    CONSTRAINT FK_JUEGO FOREIGN KEY (ID_JUEGO) REFERENCES JUEGO(ID_JUEGO)
);

CREATE TABLE JORNADA(
    ID_JOR_COMP NUMBER(3) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    ID_JORNADA NUMBER(3),
    FECHA_ENFENTAMIENTO DATE,
    CONSTRAINT PK_JORNADA PRIMARY KEY(ID_JOR_COMP),
    CONSTRAINT FK_JORNADA FOREIGN KEY (ID_JORNADA) REFERENCES COMPETICION(ID_COMPETICION)
);
CREATE TABLE EQUIPO(
    ID_EQUIPO NUMBER(3)GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    NOMBRE VARCHAR2(30) not null,
    FECHA_FUNDACION DATE,
    ID_COMPETICION NUMBER(3),
    PUNTOS NUMBER(4) ,
    CONSTRAINT EQUI_ID_PK PRIMARY KEY (ID_EQUIPO),
    CONSTRAINT EQUI_ID_COMP_FK FOREIGN KEY(ID_COMPETICION) REFERENCES COMPETICION(ID_COMPETICION)
);

CREATE TABLE ENFRENTAMIENTO (
    ID_ENF_JOR NUMBER(3)  GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    ID_JOR_COMP NUMBER(3),
    ID_ENFRENTAMIENTO NUMBER(3),--ESTA PROGRAMARLA EN JAVA
    HORA VARCHAR2(5) ,
    RESULTADO_LOCAL NUMBER(2),
    RESULTADO_VISITANTE NUMBER(2),
    ID_LOCAL NUMBER(3),
    ID_VISITANTE NUMBER(3),
    CONSTRAINT PK_ID_ENFRENTAMIENTO PRIMARY KEY (ID_ENF_JOR),
    CONSTRAINT FK_ID_JOR_COMP FOREIGN KEY (ID_JOR_COMP) REFERENCES JORNADA(ID_JOR_COMP),
    CONSTRAINT FK_EQUIPO_LOCAL FOREIGN KEY (ID_LOCAL) REFERENCES EQUIPO(ID_EQUIPO),
    CONSTRAINT FK_EQUIPO_VISITANTE FOREIGN KEY (ID_VISITANTE) REFERENCES EQUIPO(ID_EQUIPO)
);


CREATE TABLE PATROCINADOR(
    ID_PATROCINADOR NUMBER(3) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    NOMBRE VARCHAR2(30) not null,
    ID_EQUIPO NUMBER(3),
    CONSTRAINT PATRO_ID_PK PRIMARY KEY (ID_PATROCINADOR),
    CONSTRAINT PATRO_ID_EQUI_FK FOREIGN KEY (ID_EQUIPO) REFERENCES EQUIPO(ID_EQUIPO)
);

CREATE TABLE USUARIO(
    ID_USUARIO NUMBER(3) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    NOMBRE VARCHAR2(30)not null,
    CONTRASENA VARCHAR2(50)not null,
    TIPO VARCHAR2(30) CHECK (tipo IN ('administrador', 'usuario')),
    CONSTRAINT USU_ID_PK PRIMARY KEY (ID_USUARIO)
);

CREATE TABLE JUGADOR(
    ID_INTEGRANTE NUMBER(3) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    NOMBRE VARCHAR2(30) not null,
    APELLIDO1 VARCHAR2(30) not null,
    APELLIDO2 VARCHAR2(30) not null,
    SUELDO NUMBER(6) not null,
    NACIONALIDAD VARCHAR2(30)not null,
    FECHA_NACIMIENTO DATE not null,
    NICKNAME VARCHAR2(30) not null,
    ROL VARCHAR2(30) not null,
    ID_EQUIPO NUMBER(3),
    CONSTRAINT JUGA_ID_PK PRIMARY KEY (ID_INTEGRANTE),
    CONSTRAINT JUGA_ID_EQUI_FK FOREIGN KEY (ID_EQUIPO) REFERENCES EQUIPO(ID_EQUIPO)
);

CREATE TABLE ENTRENADOR(
    ID_INTEGRANTE NUMBER(3) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    NOMBRE VARCHAR2(30) not null,
    APELLIDO1 VARCHAR2(30) not null,
    APELLIDO2 VARCHAR2(30) not null,
    SUELDO NUMBER(6) not null,
    ID_EQUIPO NUMBER(3),
    CONSTRAINT ENTRE_ID_PK PRIMARY KEY (ID_INTEGRANTE),
    CONSTRAINT ENTRE_ID_EQUI_FK FOREIGN KEY (ID_EQUIPO) REFERENCES EQUIPO(ID_EQUIPO)
);
CREATE TABLE ASISTENTE(
    ID_INTEGRANTE NUMBER(3) GENERATED ALWAYS AS IDENTITY,
    NOMBRE VARCHAR2(30),
    APELLIDO1 VARCHAR2(30),
    APELLIDO2 VARCHAR2(30),
    SUELDO NUMBER(6),
    ID_EQUIPO NUMBER(3),
    CONSTRAINT ASIST_ID_PK PRIMARY KEY (ID_INTEGRANTE),
    CONSTRAINT ASIST_ID_EQUI_FK FOREIGN KEY (ID_EQUIPO) REFERENCES EQUIPO(ID_EQUIPO)
);

/*-----------------------------CREACION DE TRIGGERS-----------------------------------*/

create or replace TRIGGER TR_NUM_JUGADORES_MAYOR6
BEFORE INSERT OR UPDATE ON JUGADOR
FOR EACH ROW
DECLARE
    V_NUMJUGADORES NUMBER(2);
    V_ESTADO COMPETICION.ESTADO%TYPE;
    E_NUMJUGADORINCORRECTO EXCEPTION;
BEGIN 
    SELECT COUNT(*) INTO V_NUMJUGADORES
    FROM JUGADOR
    WHERE ID_EQUIPO = :NEW.ID_EQUIPO;

    IF V_NUMJUGADORES > 6 THEN 
        RAISE E_NUMJUGADORINCORRECTO;
    END IF; 

EXCEPTION 
    WHEN TOO_MANY_ROWS THEN 
        RAISE_APPLICATION_ERROR(-20001,'HAY MAS DE UN VALOR');
    WHEN NO_DATA_FOUND THEN 
        RAISE_APPLICATION_ERROR(-20002,'VALOR NO ENCONTRADO');
    WHEN E_NUMJUGADORINCORRECTO THEN 
        RAISE_APPLICATION_ERROR(-20003,'EL NUMERO DE JUGADORES ES INCORRECTO');
    WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20004,'ERROR INESPERADO');
END;


/*-----creacion de trigger bloqueo de equipos cuando la competicion esta iniciada-----*/

CREATE OR REPLACE TRIGGER bloqueo_competicion_cerrada
BEFORE INSERT OR DELETE OR UPDATE ON EQUIPO
FOR EACH ROW
DECLARE
    v_estado_competicion VARCHAR2(20);
BEGIN
    SELECT ESTADO INTO v_estado_competicion FROM COMPETICION WHERE ID_COMPETICION = :NEW.ID_COMPETICION;
    
    IF v_estado_competicion = 'cerrado' THEN
        RAISE_APPLICATION_ERROR(-20001, 'No se pueden realizar operaciones en EQUIPO cuando la competición está cerrada.');
    END IF;
END;

/*-------*/

CREATE OR REPLACE TRIGGER bloqueo_competicion_cerrada
BEFORE INSERT OR DELETE OR UPDATE ON EQUIPO
FOR EACH ROW
DECLARE
    v_estado_competicion VARCHAR2(20);
BEGIN
    SELECT ESTADO INTO v_estado_competicion FROM COMPETICION WHERE ID_COMPETICION = :NEW.ID_COMPETICION;
    
    IF v_estado_competicion = 'cerrado' THEN
        RAISE_APPLICATION_ERROR(-20001, 'No se pueden realizar operaciones en EQUIPO cuando la competición está cerrada.');
    END IF;
END;
INSERT INTO JUGADOR (NOMBRE, APELLIDO1, APELLIDO2, SUELDO, NACIONALIDAD, FECHA_NACIMIENTO, NICKNAME, ROL, ID_EQUIPO) VALUES ('Jugador1', 'Apellido1', 'Apellido2', 1000,
 'Nacionalidad1', TO_DATE('1990-11-01', 'YYYY-MM-DD'), 'Nick1', 'Rol1', 3);


 /*Trigger para que la suma de sueldos de todos los jugadores de un mismo equipo no pueda ser superior a 200.000€*/

 CREATE OR REPLACE TRIGGER TR_MAX_SAL
BEFORE INSERT OR UPDATE ON JUGADOR
FOR EACH ROW
DECLARE
    V_SUELDO_TOTAL_EQUIPO JUGADOR.SUELDO%TYPE;
    E_SUELDOMAXINCORRECTO EXCEPTION;
BEGIN 
    SELECT SUM(SUELDO) INTO V_SUELDO_TOTAL_EQUIPO
    FROM JUGADOR
    WHERE ID_EQUIPO = :NEW.ID_EQUIPO;
    
    IF V_SUELDO_TOTAL_EQUIPO + NVL(:NEW.SUELDO, 0) - NVL(:OLD.SUELDO, 0) > 200000 THEN
        RAISE E_SUELDOMAXINCORRECTO;
    END IF;
    
EXCEPTION
    WHEN TOO_MANY_ROWS THEN 
        RAISE_APPLICATION_ERROR(-20001,'HAY MAS DE UN VALOR');
    WHEN NO_DATA_FOUND THEN 
        RAISE_APPLICATION_ERROR(-20002,'VALOR NO ENCONTRADO');
    WHEN E_SUELDOMAXINCORRECTO THEN 
        RAISE_APPLICATION_ERROR(-20003,'LA SUMA DE LOS SUELDOS DE UN MISMO EQUIPO NO PUEDE SUPERAR LOS 200.000€');
    WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20004,'ERROR INESPERADO'); 
END;

/*Trigger sueldo Minimo Interprofesional*/

CREATE OR REPLACE TRIGGER TR_VALIDAR_SUELDO_MINIMO
BEFORE INSERT OR UPDATE ON JUGADOR
FOR EACH ROW
DECLARE
    E_SUELDO_BAJO EXCEPTION;
BEGIN
    IF :NEW.SUELDO < 1134 THEN
        RAISE E_SUELDO_BAJO;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN 
        RAISE_APPLICATION_ERROR(-20022, 'VALOR NO ENCONTRADO');
    WHEN E_SUELDO_BAJO THEN
        RAISE_APPLICATION_ERROR(-20023, 'EL SUELDO NO PUEDE SER MENOR AL MINIMO INTERPROFESIONAL');
    WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20024, 'ERROR INESPERADO');
END;  

/*Trigger para que no se pueda cerrar una competicion si el numero de equipos es impar*/

CREATE OR REPLACE TRIGGER TR_NUM_EQUIPOS_PAR
BEFORE INSERT OR UPDATE ON COMPETICION
FOR EACH ROW
DECLARE
    V_ESTADO_VOMPETICION COMPETICION.ESTADO%TYPE;
    V_NUM_EQUIPOS NUMBER(2);
    E_NUM_EQUIPOS_IMPAR EXCEPTION;
BEGIN 
    IF :NEW.ESTADO = UPPER('CERRADO') THEN
        SELECT COUNT(*) INTO V_NUM_EQUIPOS
        FROM EQUIPO
        WHERE ID_COMPETICION = :NEW.ID_COMPETICION;
    
        IF MOD(V_NUM_EQUIPOS, 2) <> 0 THEN 
            RAISE E_NUM_EQUIPOS_IMPAR;
        END IF; 
    END IF;

EXCEPTION 
    WHEN TOO_MANY_ROWS THEN 
        RAISE_APPLICATION_ERROR(-20001, 'HAY MAS DE UN VALOR');
    WHEN NO_DATA_FOUND THEN 
        RAISE_APPLICATION_ERROR(-20002, 'VALOR NO ENCONTRADO');
    WHEN E_NUM_EQUIPOS_IMPAR THEN 
        RAISE_APPLICATION_ERROR(-20003, 'EL NUMERO DE EQUIPOS ES IMPAR. DEBE DE SER PAR PARA QUE COMIENCE LA COMPETICION');
    WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20004, 'ERROR INESPERADO');
END;

/*inserts*/


-- Inserts para la tabla JUEGO
INSERT INTO JUEGO (NOMBRE, EMPRESA, FECHA_LANZAMIENTO) VALUES ('Juego1', 'Empresa1', TO_DATE('2022-01-01', 'YYYY-MM-DD'));
INSERT INTO JUEGO (NOMBRE, EMPRESA, FECHA_LANZAMIENTO) VALUES ('Juego2', 'Empresa2', TO_DATE('2022-02-01', 'YYYY-MM-DD'));
INSERT INTO JUEGO (NOMBRE, EMPRESA, FECHA_LANZAMIENTO) VALUES ('Juego3', 'Empresa3', TO_DATE('2022-03-01', 'YYYY-MM-DD'));

-- Inserts para la tabla COMPETICION
INSERT INTO COMPETICION (NOMBRE, FECHA_INICIO, FECHA_FIN, ESTADO, ID_JUEGO) VALUES ('Competicion1', TO_DATE('2022-01-01', 'YYYY-MM-DD'), TO_DATE('2022-01-10', 'YYYY-MM-DD'), 'abierto', 1);
INSERT INTO COMPETICION (NOMBRE, FECHA_INICIO, FECHA_FIN, ESTADO, ID_JUEGO) VALUES ('Competicion2', TO_DATE('2022-02-01', 'YYYY-MM-DD'), TO_DATE('2022-02-10', 'YYYY-MM-DD'), 'cerrado', 2);
INSERT INTO COMPETICION (NOMBRE, FECHA_INICIO, FECHA_FIN, ESTADO, ID_JUEGO) VALUES ('Competicion3', TO_DATE('2022-03-01', 'YYYY-MM-DD'), TO_DATE('2022-03-10', 'YYYY-MM-DD'), 'abierto', 3);

-- Inserts para la tabla JORNADA
INSERT INTO JORNADA (ID_JORNADA, FECHA_ENFENTAMIENTO) VALUES (1, TO_DATE('2022-01-01', 'YYYY-MM-DD'));
INSERT INTO JORNADA (ID_JORNADA, FECHA_ENFENTAMIENTO) VALUES (2, TO_DATE('2022-02-01', 'YYYY-MM-DD'));
INSERT INTO JORNADA (ID_JORNADA, FECHA_ENFENTAMIENTO) VALUES (3, TO_DATE('2022-03-01', 'YYYY-MM-DD'));

-- Inserts para la tabla EQUIPO
INSERT INTO EQUIPO (NOMBRE, FECHA_FUNDACION, ID_COMPETICION, PUNTOS) VALUES ('Equipo1', TO_DATE('2000-01-01', 'YYYY-MM-DD'), 1, NULL);
INSERT INTO EQUIPO (NOMBRE, FECHA_FUNDACION, ID_COMPETICION, PUNTOS) VALUES ('Equipo2', TO_DATE('2000-02-01', 'YYYY-MM-DD'), 1, NULL);
INSERT INTO EQUIPO (NOMBRE, FECHA_FUNDACION, ID_COMPETICION, PUNTOS) VALUES ('Equipo3', TO_DATE('2000-03-01', 'YYYY-MM-DD'), 2, NULL);

-- Inserts para la tabla ENFRENTAMIENTO
INSERT INTO ENFRENTAMIENTO (ID_JOR_COMP, ID_ENFRENTAMIENTO, HORA, RESULTADO_LOCAL, RESULTADO_VISITANTE, ID_LOCAL, ID_VISITANTE) VALUES (1, 1, '12:00', 0, 0, 1, 2);
INSERT INTO ENFRENTAMIENTO (ID_JOR_COMP, ID_ENFRENTAMIENTO, HORA, RESULTADO_LOCAL, RESULTADO_VISITANTE, ID_LOCAL, ID_VISITANTE) VALUES (1, 2, '15:00', 0, 0, 3, 1);
INSERT INTO ENFRENTAMIENTO (ID_JOR_COMP, ID_ENFRENTAMIENTO, HORA, RESULTADO_LOCAL, RESULTADO_VISITANTE, ID_LOCAL, ID_VISITANTE) VALUES (2, 3, '12:00', NULL, NULL, 2, 3);

-- Inserts para la tabla PATROCINADOR
INSERT INTO PATROCINADOR (NOMBRE, ID_EQUIPO) VALUES ('Patrocinador1', 1);
INSERT INTO PATROCINADOR (NOMBRE, ID_EQUIPO) VALUES ('Patrocinador2', 2);
INSERT INTO PATROCINADOR (NOMBRE, ID_EQUIPO) VALUES ('Patrocinador3', 3);

-- Inserts para la tabla USUARIO
INSERT INTO USUARIO (NOMBRE, CONTRASENA, TIPO) VALUES ('ander', 'contrasena1', 'administrador');
INSERT INTO USUARIO (NOMBRE, CONTRASENA, TIPO) VALUES ('oier', 'contrasena2', 'usuario');
INSERT INTO USUARIO (NOMBRE, CONTRASENA, TIPO) VALUES ('iñigo', 'contrasena3', 'usuario');

-- Inserts para la tabla JUGADOR
INSERT INTO JUGADOR (NOMBRE, APELLIDO1, APELLIDO2, SUELDO, NACIONALIDAD, FECHA_NACIMIENTO, NICKNAME, ROL, ID_EQUIPO) VALUES ('Jugador1', 'Apellido1', 'Apellido2', 1000, 'Nacionalidad1', TO_DATE('1990-11-01', 'YYYY-MM-DD'), 'Nick1', 'Rol1', 1);
INSERT INTO JUGADOR (NOMBRE, APELLIDO1, APELLIDO2, SUELDO, NACIONALIDAD, FECHA_NACIMIENTO, NICKNAME, ROL, ID_EQUIPO) VALUES ('Jugador2', 'Apellido1', 'Apellido2', 1200, 'Nacionalidad2', TO_DATE('1991-02-01', 'YYYY-MM-DD'), 'Nick2', 'Rol2', 1);
INSERT INTO JUGADOR (NOMBRE, APELLIDO1, APELLIDO2, SUELDO, NACIONALIDAD, FECHA_NACIMIENTO, NICKNAME, ROL, ID_EQUIPO) VALUES ('Jugador3', 'Apellido1', 'Apellido2', 1500, 'Nacionalidad3', TO_DATE('1992-06-01', 'YYYY-MM-DD'), 'Nick3', 'Rol3', 2);

-- Inserts para la tabla ENTRENADOR
INSERT INTO ENTRENADOR (NOMBRE, APELLIDO1, APELLIDO2, SUELDO, ID_EQUIPO) VALUES ('bryan', 'Apellido1', 'Apellido2', 2000, 1);
INSERT INTO ENTRENADOR (NOMBRE, APELLIDO1, APELLIDO2, SUELDO, ID_EQUIPO) VALUES ('ander', 'Apellido1', 'Apellido2', 2200, 2);
INSERT INTO ENTRENADOR (NOMBRE, APELLIDO1, APELLIDO2, SUELDO, ID_EQUIPO) VALUES ('oier', 'Apellido1', 'Apellido2', 2500, 3);

-- Inserts para la tabla ASISTENTE
INSERT INTO ASISTENTE (NOMBRE, APELLIDO1, APELLIDO2, SUELDO, ID_EQUIPO) VALUES ('iñigo', 'Apellido1', 'Apellido2', 1000, 1);
INSERT INTO ASISTENTE (NOMBRE, APELLIDO1, APELLIDO2, SUELDO, ID_EQUIPO) VALUES ('oier', 'Apellido1', 'Apellido2', 1200, 2);
INSERT INTO ASISTENTE (NOMBRE, APELLIDO1, APELLIDO2, SUELDO, ID_EQUIPO) VALUES ('bryan', 'Apellido1', 'Apellido2', 1500, 3);
