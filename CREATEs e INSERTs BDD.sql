DROP TABLE IF EXISTS Premium;
DROP TABLE IF EXISTS Basica;
DROP TABLE IF EXISTS SuscripcionesRoles; 
DROP TABLE IF EXISTS TiposSuscripciones; 
DROP TABLE IF EXISTS Compras; 
DROP TABLE IF EXISTS Suscripciones; 
DROP TABLE IF EXISTS ActividadesCatalogo; 
DROP TABLE IF EXISTS Catalogos; 
DROP TABLE IF EXISTS Actividades; 
DROP TABLE IF EXISTS Mantienen;
DROP TABLE IF EXISTS Salas; 
DROP TABLE IF EXISTS Clientes;
DROP TABLE IF EXISTS Facturas; 
DROP TABLE IF EXISTS Monitores; 
DROP TABLE IF EXISTS Nutricionistas; 
DROP TABLE IF EXISTS Mantenimiento; 
DROP TABLE IF EXISTS Recepcion; 
DROP TABLE IF EXISTS EmpleadosRoles; 
DROP TABLE IF EXISTS Roles; 
DROP TABLE IF EXISTS Empleados; 

CREATE TABLE Clientes(
dniCliente VARCHAR (9) PRIMARY KEY,
nombre VARCHAR(255) NOT NULL, 
direccion VARCHAR(255), 
activo TINYINT(1) NOT NULL DEFAULT 1
);

CREATE TABLE Facturas(
numFactura INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
fecha DATE, 
importeTotal DECIMAL(15,2)
); 

CREATE TABLE Salas(
idSala INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
aforo INT 
);

CREATE TABLE Catalogos(
idCatalogo INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
numActividades INT 
);

CREATE TABLE Empleados(
dniEmpleado VARCHAR(9) PRIMARY KEY,
nombre VARCHAR(255)
);

CREATE TABLE Roles(
idRol INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(50)
); 

CREATE TABLE EmpleadosRoles (
dniEmpleado VARCHAR(9),
idRol INT,
PRIMARY KEY (dniEmpleado),
FOREIGN KEY (dniEmpleado) REFERENCES Empleados(dniEmpleado) ON DELETE CASCADE,
FOREIGN KEY (idRol) REFERENCES Roles(idRol) ON DELETE CASCADE
);

CREATE TABLE Monitores(
idRol INT PRIMARY KEY,
salario DECIMAL(10,2) NOT NULL, 
FOREIGN KEY (idRol) REFERENCES Roles(idRol) ON DELETE CASCADE
); 

CREATE TABLE Nutricionistas(
idRol INT PRIMARY KEY, 
salario DECIMAL(10,2) NOT NULL, 
FOREIGN KEY (idRol) REFERENCES Roles(idRol) ON DELETE CASCADE
); 

CREATE TABLE Mantenimiento(
idRol INT PRIMARY KEY, 
salario DECIMAL(10,2) NOT NULL, 
FOREIGN KEY (idRol) REFERENCES Roles(idRol) ON DELETE CASCADE
); 

CREATE TABLE Recepcion(
idRol INT PRIMARY KEY, 
salario DECIMAL(10,2) NOT NULL, 
FOREIGN KEY (idRol) REFERENCES Roles(idRol) ON DELETE CASCADE
); 

CREATE TABLE Mantienen(
dniEmpleado VARCHAR(9), 
idSala INT NOT NULL, 
PRIMARY KEY (dniEmpleado, idSala), 
FOREIGN KEY (dniEmpleado) REFERENCES Empleados(dniEmpleado),
FOREIGN KEY (idSala) REFERENCES Salas(idSala) ON DELETE CASCADE
);

CREATE TABLE Actividades(
tipoActividad VARCHAR(255), 
fecha DATE, 
idSala INT NOT NULL,
dniEmpleado VARCHAR(9),
PRIMARY KEY (tipoActividad, fecha, idSala), 
FOREIGN KEY (idSala) REFERENCES Salas(idSala) ON DELETE CASCADE,
FOREIGN KEY (dniEmpleado) REFERENCES Empleados(dniEmpleado)
); 

CREATE TABLE Suscripciones(
numSuscripcion INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(50),
idTipoSuscripcion INT
); 

CREATE TABLE Basica(
idTipoSuscripcion INT, 
numSuscripcion INT PRIMARY KEY, 
precio DECIMAL(10, 2) NOT NULL,
duracion INT,
tipoActividad VARCHAR(255), 
fecha DATE, 
idSala INT NOT NULL,
FOREIGN KEY (tipoActividad, fecha, idSala) REFERENCES Actividades(tipoActividad, fecha, idSala),
FOREIGN KEY (numSuscripcion) REFERENCES Suscripciones(numSuscripcion) ON DELETE CASCADE
);

CREATE TABLE Premium(
idTipoSuscripcion INT, 
numSuscripcion INT PRIMARY KEY, 
precio DECIMAL(10, 2) NOT NULL,
duracion INT,
dniEmpleado VARCHAR(9),
idCatalogo INT, 
FOREIGN KEY (dniEmpleado) REFERENCES Empleados(dniEmpleado),
FOREIGN KEY (idCatalogo) REFERENCES Catalogos(idCatalogo),
FOREIGN KEY (numSuscripcion) REFERENCES Suscripciones(numSuscripcion) ON DELETE CASCADE
);

CREATE TABLE ActividadesCatalogo(
idCatalogo INT NOT NULL, 
tipoActividad VARCHAR(255), 
fechaActividad DATE, 
idSala INT, 
PRIMARY KEY(idCatalogo, tipoActividad, fechaActividad, idSala), 
FOREIGN KEY (idCatalogo) REFERENCES Catalogos(idCatalogo),
FOREIGN KEY (tipoActividad, fechaActividad, idSala) REFERENCES Actividades(tipoActividad, fecha, idSala) ON DELETE CASCADE
);

CREATE TABLE Compras(
idCompra INT NOT NULL AUTO_INCREMENT,
numSuscripcion INT, 
dniCliente VARCHAR(9) NOT NULL, 
fecha DATE, 
metodoPago VARCHAR(255) CHECK (metodoPago IN ('Efectivo', 'Tarjeta', 'Transferencia Bancaria', 'Bizum')),
numFactura INT NOT NULL, 
dniEmpleado VARCHAR(9), 
PRIMARY KEY (idCompra),
FOREIGN KEY (numSuscripcion) REFERENCES Suscripciones(numSuscripcion), 
FOREIGN KEY (dniCliente) REFERENCES Clientes(dniCliente),
FOREIGN KEY (numFactura) REFERENCES Facturas(numFactura), 
FOREIGN KEY (dniEmpleado) REFERENCES Empleados(dniEmpleado)
);

INSERT INTO Empleados (dniEmpleado, nombre) VALUES ('06013483H', 'Nicolas'); 
INSERT INTO Empleados (dniEmpleado, nombre) VALUES ('1234567A', 'Jaime'); 
INSERT INTO Empleados (dniEmpleado, nombre) VALUES ('1234567B', 'Juan'); 
INSERT INTO Empleados (dniEmpleado, nombre) VALUES ('1234567C', 'Gabriel'); 

INSERT INTO Roles (nombre) VALUES ('Mantenimiento');
INSERT INTO Roles (nombre) VALUES ('Monitor');
INSERT INTO Roles (nombre) VALUES ('Nutricionista');
INSERT INTO Roles (nombre) VALUES ('Recepcion');

INSERT INTO EmpleadosRoles (dniEmpleado, idRol) VALUES ('06013483H', 1);
INSERT INTO EmpleadosRoles (dniEmpleado, idRol) VALUES ('1234567A', 2);
INSERT INTO EmpleadosRoles (dniEmpleado, idRol) VALUES ('1234567B', 3);
INSERT INTO EmpleadosRoles (dniEmpleado, idRol) VALUES ('1234567C', 4);

INSERT INTO Mantenimiento (idRol, salario) VALUES (1, 2400);
INSERT INTO Monitores (idRol, salario) VALUES (2, 2100);
INSERT INTO Nutricionistas (idRol, salario) VALUES (3, 1300);
INSERT INTO Recepcion (idRol, salario) VALUES (4, 1500);

INSERT INTO Clientes (nombre, dniCliente, direccion) VALUES ('Marlon', 'AAAAAAAAA' ,'Gran Via 4'); 
INSERT INTO Clientes (nombre, dniCliente, direccion) VALUES ('Carlos', 'BBBBBBBBB' ,'Las Tablas'); 

INSERT INTO Salas (aforo) VALUES (100);
INSERT INTO Salas (aforo) VALUES (150); 

INSERT INTO Mantienen(dniEmpleado, idSala) VALUES ('06013483H', 1);
INSERT INTO Mantienen(dniEmpleado, idSala) VALUES ('06013483H', 2);

INSERT INTO Actividades (tipoActividad, fecha, idSala, dniEmpleado) VALUES ('Yoga', '2025-03-19', 1, '1234567A');
INSERT INTO Actividades (tipoActividad, fecha, idSala, dniEmpleado) VALUES ('Spinning', '2025-03-20', 2, '1234567A'); 

INSERT INTO Catalogos (numActividades) VALUES (2); 

INSERT INTO ActividadesCatalogo VALUES (1, 'Yoga', '2025-03-19', 1); 
INSERT INTO ActividadesCatalogo VALUES (1, 'Spinning', '2025-03-20', 2); 

INSERT INTO Suscripciones (nombre, idTipoSuscripcion) VALUES ('suscripcion para novatos', 1);
INSERT INTO Basica (idTipoSuscripcion, numSuscripcion, precio, duracion, tipoActividad, fecha, idSala) VALUES (1, 1, '30', '30', 'Yoga', '2025-03-19', 1);
INSERT INTO Suscripciones (nombre) VALUES ('suscripcion para pros'); 
INSERT INTO Premium (idTipoSuscripcion, numSuscripcion, precio, duracion, dniEmpleado, idCatalogo) VALUES (1, 2, '90', '120', '1234567B', 1);


INSERT INTO Facturas (fecha, importeTotal) VALUES ('2025-04-28', 30.00);
INSERT INTO Facturas (fecha, importeTotal) VALUES ('2025-04-29', 90.00);
INSERT INTO Facturas (fecha, importeTotal) VALUES ('2025-05-01', 90.00);
INSERT INTO Compras (numSuscripcion, dniCliente, fecha, metodoPago, numFactura, dniEmpleado) VALUES (1, 'AAAAAAAAA', '2025-04-28', 'Tarjeta', 1, '1234567C');
INSERT INTO Compras (numSuscripcion, dniCliente, fecha, metodoPago, numFactura, dniEmpleado) VALUES (2, 'AAAAAAAAA', '2025-04-28', 'Tarjeta', 2, '1234567C');
INSERT INTO Compras (numSuscripcion, dniCliente, fecha, metodoPago, numFactura, dniEmpleado) VALUES (2, 'AAAAAAAAA', '2025-04-29', 'Transferencia Bancaria', 3, '1234567C');

SELECT * FROM Salas; 
SELECT * FROM Clientes; 
SELECT * FROM Empleados;
SELECT * FROM Facturas;