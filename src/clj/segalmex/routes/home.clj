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
  (layout/render request "municipio.html" ))
;{:localidades (db/get-localidades)}
(defn localidad-page [request]
  (layout/render request "localidad.html" ))
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
   ])

