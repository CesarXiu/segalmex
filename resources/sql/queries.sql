-- :name get-estados :? :*
-- :doc Obtener los estados
SELECT * FROM estados

-- :name create-estados! :! :n
-- :Agregar un nuevo estado
INSERT INTO estados
(nombre)
VALUES (:nombre)

-- :name update-estados! :! :n
-- :doc Actualiza nombre de un estado
UPDATE estados
SET nombre = :nuevo_nombre
WHERE estado_id = :estado_id

-- :name delete-estados! :! :n
-- :doc Eliminar un estado
DELETE FROM estados
WHERE estado_id = :estado_id

-- :name clear-estados! :! :*
-- :doc Eliminar todos los estados
DELETE FROM estados