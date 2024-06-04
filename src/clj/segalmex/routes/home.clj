(ns segalmex.routes.home
  (:require
   [segalmex.layout :as layout]
   [segalmex.db.core :as db]
   [clojure.java.io :as io]
   [segalmex.middleware :as middleware]
   [ring.util.response]
   [ring.util.http-response :as response]))

(defn home-page [request]
  (layout/render request "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))
(defn beneficiarios-page [request]
  (layout/render request "beneficiarios.html"))
(defn localidades-page [request]
  (layout/render request "localidades.html"))
(defn estado-page [request]
  (layout/render request "estado.html"))
(defn municipio-page [request]
  (layout/render request "municipio.html"))
(defn localidad-page [request]
  (layout/render request "localidad.html"))


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
   
   ])

