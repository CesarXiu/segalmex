(ns segalmex.routes.home
  (:require
   [segalmex.layout :as layout]
   [segalmex.db.core :as db]
   [clojure.java.io :as io]
   [segalmex.middleware :as middleware]
   [ring.util.response]
   [ring.util.http-response :as response]))

(defn home-page [request]
  (layout/render request "home.html"))
(defn beneficiarios-page [request]
  (layout/render request "beneficiarios.html"))
(defn localidades-page [request]
  (layout/render request "localidades.html" ))
;{:estados (db/get-estados)}
(defn estado-page [request]
  (layout/render request "estado.html" {:estados (db/get-estados)} ))
;{:municipios (db/get-municipios)}
(defn municipio-page [request]
  (layout/render request "municipio.html" {:municipios (db/get-municipios), :estados (db/get-estados) } ))
;{:localidades (db/get-localidades)}
(defn localidad-page [request]
  (layout/render request "localidad.html" {:localidades (db/get-localidades), :municipios (db/get-municipios)} ))
(defn apoyo-page [request]
  (layout/render request "apoyo.html"))
(defn post-estados [{:keys [params]}]
  (db/create-estados! params)
  (response/found "/localidades/estados"))
(defn put-estados [{:keys [params]}]
  (db/update-estados! params)
  (response/found "/localidades/estados"))
(defn delete-estados [{:keys [params]}]
  (db/delete-estados! params)
  (response/found "/localidades/estados"))
(defn post-municipios [{:keys [params]}]
  (db/create-municipios! params)
  (response/found "/localidades/municipios"))
(defn put-municipios [{:keys [params]}]
  (db/update-municipios! params)
  (response/found "/localidades/municipios"))
(defn delete-municipios [{:keys [params]}]
  (db/delete-municipios! params)
  (response/found "/localidades/municipios"))
(defn post-localidades [{:keys [params]}]
  (db/create-localidades! params)
  (response/found "/localidades/localidad"))
(defn put-localidades [{:keys [params]}]
  (db/update-localidades! params)
  (response/found "/localidades/localidad"))
(defn delete-localidades [{:keys [params]}]
  (db/delete-localidades! params)
  (response/found "/localidades/localidad"))

(defn home-routes []
  [""
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats]}
   ["/" {:get home-page}]
   ["/beneficiarios" {:get beneficiarios-page}]
   ["/localidades" {:get localidades-page}]
   ["/localidades/estados" {:get estado-page}]
   ["/localidades/municipios" {:get municipio-page}]
   ["/localidades/localidad" {:get localidad-page}]
   ["/apoyo" {:get apoyo-page}]
   ["/localidades/estados/nuevo" {:post post-estados}]
   ["/localidades/estados/actualizar" {:post put-estados}]
   ["/localidades/estados/eliminar" {:post delete-estados}]
   ["/localidades/municipios/nuevo" {:post post-municipios}]
   ["/localidades/municipios/actualizar" {:post put-municipios}]
   ["/localidades/municipios/eliminar" {:post delete-municipios}] 
   ["/localidades/localidad/nuevo" {:post post-localidades}] 
   ["/localidades/localidad/actualizar" {:post put-localidades}] 
   ["/localidades/localidad/eliminar" {:post delete-localidades}]
   ])

