(ns segalmex.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [segalmex.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[segalmex started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[segalmex has shut down successfully]=-"))
   :middleware wrap-dev})
