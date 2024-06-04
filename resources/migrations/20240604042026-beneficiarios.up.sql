CREATE TABLE beneficiarios
(
    curp VARCHAR(30) PRIMARY KEY,
    nombres VARCHAR(250),
    primer_apellido VARCHAR(250),
    segundo_apellido VARCHAR(250),
    estado_id INT,
    municipio_id INT,
    localidad_id INT,
    FOREIGN KEY (estado_id) REFERENCES estados(estado_id),
    FOREIGN KEY (municipio_id) REFERENCES municipios(municipio_id),
    FOREIGN KEY (localidad_id) REFERENCES localidades(localidad_id)
);