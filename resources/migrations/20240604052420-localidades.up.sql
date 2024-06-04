CREATE TABLE localidades (
    localidad_id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    municipio_id INTEGER NOT NULL,
    FOREIGN KEY (municipio_id) REFERENCES municipios (municipio_id) ON DELETE CASCADE
);