(ns segalmex.db.core-test
  (:require
   [segalmex.db.core :refer [*db*] :as db]
   [java-time.pre-java8]
   [luminus-migrations.core :as migrations]
   [clojure.test :refer :all]
   [next.jdbc :as jdbc]
   [segalmex.config :refer [env]]
   [mount.core :as mount]))

(use-fixtures
  :once
  (fn [f]
    (mount/start
     #'segalmex.config/env
     #'segalmex.db.core/*db*)
    (migrations/migrate ["migrate"] (select-keys env [:database-url]))
    (f)))

(deftest test-estados
  (jdbc/with-transaction [t-conn *db* {:rollback-only true}]
    (is (= 1 (db/create-estados!
              t-conn
              {
               :nombre "Quintana Roo"}
              {:connection t-conn})))
    (is (= {:estado_id         1
            :nombre "Quintana Roo"}
           (db/get-estados t-conn {})))))
(deftest test-productos
  (jdbc/with-transaction [t-conn *db* {:rollback-only true}]
    (is (= 1 (db/create-estados!
              t-conn
              {:nombre         "Carne asada"}
              {:connection t-conn})))
    (is (= {:estado_id         1 :nombre         "Carne asada"}
           (-> (db/get-estados t-conn{})(first)(select-keys [:nombre]))))))

