DROP TABLE Cliente CASCADE;
DROP TABLE Factura CASCADE; 
DROP TABLE Empleados CASCADE; 
DROP TABLE Mantenimiento CASCADE; 
DROP TABLE Monitor CASCADE; 
DROP TABLE Nutricionista CASCADE; 
DROP TABLE Recepcion CASCADE; 
DROP TABLE Actividad CASCADE; 
DROP TABLE Catalogo CASCADE; 
DROP TABLE Suscripcion CASCADE; 
DROP TABLE Basica CASCADE; 
DROP TABLE Premium CASCADE; 
DROP TABLE Salas CASCADE; 
DROP TABLE Generan CASCADE; 
DROP TABLE Actividad_Catalogo; 

INSERT INTO Factura (Fecha, ImporteTotal) VALUES ('2015-05-01', 12.22);
SELECT*FROM Factura; 

CREATE TABLE Cliente(
idCliente INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(255) NOT NULL, 
apellido1 VARCHAR(255)
);

CREATE TABLE Factura(
numFactura INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
fecha DATE, 
importeTotal DECIMAL(15,2)
); 

CREATE TABLE Salas(
idSala INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
aforo INT 
);

CREATE TABLE Catalogo(
idCatalogo INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
numActividades INT 
);

CREATE TABLE Empleados(
dni VARCHAR(9) NOT NULL PRIMARY KEY,
nombre VARCHAR(255), 
sueldo DECIMAL(15,2)
);

CREATE TABLE Mantenimiento(
dni VARCHAR(9) NOT NULL PRIMARY KEY, 
FOREIGN KEY (dni) REFERENCES Empleados (dni)
);

CREATE TABLE Nutricionista(
dni VARCHAR(9) NOT NULL PRIMARY KEY, 
FOREIGN KEY (dni) REFERENCES Empleados (dni)
);

CREATE TABLE Monitor(
dni VARCHAR(9) NOT NULL PRIMARY KEY, 
FOREIGN KEY (dni) REFERENCES Empleados (dni)
);

CREATE TABLE Recepcion(
dni VARCHAR(9) NOT NULL PRIMARY KEY, 
FOREIGN KEY (dni) REFERENCES Empleados (dni)
);

CREATE TABLE Suscripcion(
precio DECIMAL(15,2),
duracion INT CHECK (duracion>0),
numSuscripcion INT NOT NULL AUTO_INCREMENT,
metodoPago VARCHAR(255),
idCliente INT NOT NULL,
PRIMARY KEY (numSuscripcion),
FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente)
); 

CREATE TABLE Basica(
numSuscripcion INT NOT NULL, 
PRIMARY KEY (numSuscripcion),
FOREIGN KEY (numSuscripcion) REFERENCES Suscripcion (numSuscripcion)
);
CREATE TABLE Premium(
numSuscripcion INT NOT NULL, 
dniNutricionista VARCHAR(9),
idCatalogo INT NOT NULL, 
PRIMARY KEY (numSuscripcion),
FOREIGN KEY (numSuscripcion) REFERENCES Suscripcion (numSuscripcion),
FOREIGN KEY (dniNutricionista) REFERENCES Nutricionista (dni), 
FOREIGN KEY (idCatalogo) REFERENCES Catalogo (idCatalogo)
);

CREATE TABLE Actividad(
tipoActividad VARCHAR(255), 
fecha DATE, 
idSala INT NOT NULL,
dniMonitor VARCHAR(9) NOT NULL,
PRIMARY KEY (tipoActividad, fecha, idSala), 
FOREIGN KEY (idSala) REFERENCES Salas(idSala),
FOREIGN KEY (dniMonitor) REFERENCES Monitor(dni)
); 

CREATE TABLE Mantienen(
dniEmpleado VARCHAR(9), 
idSala INT NOT NULL, 
PRIMARY KEY (dniEmpleado, idSala), 
FOREIGN KEY (dniEmpleado) REFERENCES Empleados(dni),
FOREIGN KEY (idSala) REFERENCES Salas(idSala)
);

CREATE TABLE Generan(
numFactura INT, 
dniRecepcion VARCHAR(9), 
numSuscripcion INT, 
PRIMARY KEY (numFactura, dniRecepcion, numSuscripcion),
FOREIGN KEY (numFactura) REFERENCES Factura(numFactura), 
FOREIGN KEY (dniRecepcion) REFERENCES Recepcion(dni), 
FOREIGN KEY (numSuscripcion) REFERENCES Suscripcion(numSuscripcion)
);

CREATE TABLE Actividad_Catalogo(
idCatalogo INT, 
tipoActividad VARCHAR(255), 
fechaActividad DATE, 
idSala INT, 
PRIMARY KEY(idCatalogo, tipoActividad, fechaActividad, idSala), 
FOREIGN KEY (idCatalogo) REFERENCES Catalogo(idCatalogo),
FOREIGN KEY (tipoActividad, fechaActividad, idSala) REFERENCES Actividad(tipoActividad, fecha, idSala)
);



