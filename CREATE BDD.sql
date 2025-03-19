DROP TABLE IF EXISTS Premium; 
DROP TABLE IF EXISTS Basica; 
DROP TABLE IF EXISTS Actividad_Catalogo; 
DROP TABLE IF EXISTS Catalogo; 
DROP TABLE IF EXISTS Actividad; 
DROP TABLE IF EXISTS Mantienen;
DROP TABLE IF EXISTS Sala; 
DROP TABLE IF EXISTS Compra; 
DROP TABLE IF EXISTS Suscripcion; 
DROP TABLE IF EXISTS Cliente;
DROP TABLE IF EXISTS Factura; 
DROP TABLE IF EXISTS Empleado; 

CREATE TABLE Cliente(
idCliente INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(255) NOT NULL, 
direccion VARCHAR(255), 
activo TINYINT(1) NOT NULL DEFAULT 1
);

CREATE TABLE Factura(
numFactura INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
fecha DATE, 
importeTotal DECIMAL(15,2)
); 

CREATE TABLE Sala(
idSala INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
aforo INT 
);

CREATE TABLE Catalogo(
idCatalogo INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
numActividades INT 
);

CREATE TABLE Empleado (
dni VARCHAR(9) NOT NULL PRIMARY KEY,
nombre VARCHAR(255), 
sueldo DECIMAL(15,2),
rol VARCHAR(50) NOT NULL CHECK (rol IN ('Mantenimiento', 'Monitor', 'Nutricionista', 'Recepcion'))
);


CREATE TABLE Suscripcion(
numSuscripcion INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
precio DECIMAL(15,2),
duracion INT CHECK (duracion>0)
); 

CREATE TABLE Basica(
numSuscripcion INT NOT NULL PRIMARY KEY, 
FOREIGN KEY (numSuscripcion) REFERENCES Suscripcion (numSuscripcion)
);

CREATE TABLE Premium(
numSuscripcion INT NOT NULL PRIMARY KEY, 
dniEmpleado VARCHAR(9),
idCatalogo INT NOT NULL, 
FOREIGN KEY (numSuscripcion) REFERENCES Suscripcion (numSuscripcion),
FOREIGN KEY (dniEmpleado) REFERENCES Empleado(dni), 
FOREIGN KEY (idCatalogo) REFERENCES Catalogo (idCatalogo)
);

CREATE TABLE Actividad(
tipoActividad VARCHAR(255), 
fecha DATE, 
idSala INT NOT NULL,
dniEmpleado VARCHAR(9) NOT NULL,
PRIMARY KEY (tipoActividad, fecha, idSala), 
FOREIGN KEY (idSala) REFERENCES Sala(idSala),
FOREIGN KEY (dniEmpleado) REFERENCES Empleado(dni)
); 

CREATE TABLE Mantienen(
dniEmpleado VARCHAR(9), 
idSala INT NOT NULL, 
PRIMARY KEY (dniEmpleado, idSala), 
FOREIGN KEY (dniEmpleado) REFERENCES Empleado(dni),
FOREIGN KEY (idSala) REFERENCES Sala(idSala)
);

CREATE TABLE Actividad_Catalogo(
idCatalogo INT NOT NULL, 
tipoActividad VARCHAR(255), 
fechaActividad DATE, 
idSala INT, 
PRIMARY KEY(idCatalogo, tipoActividad, fechaActividad, idSala), 
FOREIGN KEY (idCatalogo) REFERENCES Catalogo(idCatalogo),
FOREIGN KEY (tipoActividad, fechaActividad, idSala) REFERENCES Actividad(tipoActividad, fecha, idSala)
);

CREATE TABLE Compra(
numSuscripcion INT PRIMARY KEY, 
idCliente INT NOT NULL, 
fecha DATE, 
metodoPago VARCHAR(255) CHECK (metodoPago IN ('Efectivo', 'Tarjeta', 'Transferencia Bancaria', 'Bizum')),
numFactura INT NOT NULL, 
dniEmpleado VARCHAR(9),
FOREIGN KEY (numSuscripcion) REFERENCES Suscripcion(numSuscripcion), 
FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente),
FOREIGN KEY (numFactura) REFERENCES Factura (numFactura), 
FOREIGN KEY (dniEmpleado) REFERENCES Empleado(dni)
);

INSERT INTO Empleado VALUES ('06013483H', 'Nicolas', 2400, 'Mantenimiento'); 
INSERT INTO Empleado VALUES ('1234567A', 'Jaime', 1300, 'Nutricionista'); 
INSERT INTO Empleado VALUES ('1234567B', 'Juan', 1500, 'Recepcion'); 
INSERT INTO Empleado VALUES ('1234567C', 'Gabriel', 2100, 'Monitor'); 
INSERT INTO Cliente (nombre, direccion) VALUES ('Marlon', 'Gran Via 47'); 
INSERT INTO Cliente (nombre, direccion) VALUES ('Carlos', 'Las Tablas'); 
INSERT INTO Sala (aforo) VALUES (100);
INSERT INTO Sala (aforo) VALUES (150); 
INSERT INTO Actividad VALUES ('Yoga', '2025-03-19', 1, '1234567C');
INSERT INTO Actividad VALUES ('Spinning', '2025-03-20', 2, '1234567C'); 
INSERT INTO Suscripcion (precio, duracion) VALUES (80, 30);
INSERT INTO Suscripcion (precio, duracion) VALUES (20, 1); 
INSERT INTO Catalogo (numActividades) VALUES (2); 
INSERT INTO Actividad_Catalogo VALUES (1, 'Yoga', '2025-03-19', 1); 
INSERT INTO Actividad_Catalogo VALUES (1, 'Spinning', '2025-03-20', 2); 
INSERT INTO Basica VALUES (2); 
INSERT INTO Premium VALUES (1, '1234567A', 1); 
INSERT INTO Factura (Fecha, ImporteTotal) VALUES ('2015-05-01', 12.22);
SELECT * FROM Salas; 
SELECT * FROM Cliente; 
SELECT*FROM Empleados;
SELECT*FROM Factura;





