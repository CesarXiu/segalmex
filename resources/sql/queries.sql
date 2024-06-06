-- :name get-estados :? :*
-- :doc Obtener los estados
SELECT * FROM estados
-- :name get-municipios :? :*
-- :doc Obtener los municipios
SELECT municipios.municipio_id, municipios.nombre, municipios.estado_id, estados.nombre AS nombre_estado FROM municipios INNER JOIN estados ON municipios.estado_id = estados.estado_id
-- :name get-localidades :? :*
-- :doc Obtener los localidades
SELECT localidades.localidad_id, localidades.nombre, localidades.municipio_id, municipios.nombre AS nombre_municipio 
FROM localidades INNER JOIN municipios ON localidades.municipio_id = municipios.municipio_id

-- :name create-estados! :! :n
-- :Agregar un nuevo estado
INSERT INTO estados
(nombre)
VALUES (:nombre)
-- :name create-municipios! :! :n
-- :Agregar un nuevo municipio
INSERT INTO municipios
(nombre, estado_id)
VALUES (:nombre, :estado_id)
-- :name create-localidades! :! :n
-- :Agregar una nueva localidades
INSERT INTO localidades
(nombre, municipio_id)
VALUES (:nombre, :municipio_id)

-- :name update-estados! :! :n
-- :doc Actualiza nombre de un estado
UPDATE estados
SET nombre = :nuevo_nombre
WHERE estado_id = :estado_id
-- :name update-municipios! :! :n
-- :doc Actualiza nombre de un estado
UPDATE municipios
SET nombre = :nuevo_nombre, estado_id = :nuevo_estado_id
WHERE municipio_id = :municipio_id
-- :name update-localidades! :! :n
-- :doc Actualiza nombre de un estado
UPDATE localidades
SET nombre = :nuevo_nombre, municipio_id = :nuevo_municipio_id
WHERE localidad_id = :localidad_id

-- :name delete-estados! :! :n
-- :doc Eliminar un estado
DELETE FROM estados
WHERE estado_id = :estado_id
-- :name delete-municipios! :! :n
-- :doc Eliminar un estado
DELETE FROM municipios
WHERE municipio_id = :municipio_id
-- :name delete-localidades! :! :n
-- :doc Eliminar un estado
DELETE FROM localidades
WHERE localidad_id = :localidad_id

-- :name clear-estados! :! :*
-- :doc Eliminar todos los estados
DELETE FROM estados