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
(deftest delete-estados
  (jdbc/with-transaction [t-conn *db* {:rollback-only false}]
    (is (= 1 (db/clear-estados!
              t-conn
              {}
              {:connection t-conn})))
    (is (= {}
           (db/get-estados t-conn {})))))

#_(deftest test-estados
  (jdbc/with-transaction [t-conn *db* {:rollback-only true}]
    (is (= 1 (db/create-estados!
              t-conn
              {
               :nombre "Quintana Roo"}
              {:connection t-conn})))
    (is (= {:estado_id         1
            :nombre "Quintana Roo"}
           (db/get-estados t-conn {})))))


