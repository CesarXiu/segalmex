CREATE TABLE cader (
    cader_id SERIAL PRIMARY KEY,
    fecha DATE NOT NULL,
    hora VARCHAR(30) NOT NULL,
    curp INT NOT NULL,
    localidad_real VARCHAR(255),
    FOREIGN KEY (curp) REFERENCES beneficiarios(curp) ON DELETE CASCADE
)