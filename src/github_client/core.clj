(ns github-client.core
  (:require [github-client.client :refer [get-profile]])
  (:require [github-client.options :refer [read-options]])
  (:require [github-client.report :refer [get-report]])
  (:gen-class))

(defn -main
  [& args]
  (let [{:keys [username]} (read-options args)]
    (-> (get-profile username)
        (get-report))))