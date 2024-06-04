CREATE TABLE municipios
(
    municipio_id SERIAL PRIMARY KEY,
    nombre VARCHAR(250),
    estado_id INT,
    FOREIGN KEY (estado_id) REFERENCES estados(estado_id) ON DELETE CASCADE
);