-- :name get-estados :? :n
-- :Obtener los estados
SELECT * FROM estados

-- :name create-estados! :! :n
-- :Agregar un nuevo estado
INSERT INTO estados
(nombre)
VALUES (:nombre)

-- :name update-estados! :! :n
-- :Actualiza nombre de un estado
UPDATE estados
SET estados = :estados
WHERE estado_id = :estado_id

-- :name delete-estados! :! :n
-- :Eliminar un estado
DELETE FROM estados
WHERE estado_id = :estado_id