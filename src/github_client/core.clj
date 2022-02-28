(ns github-client.core
  (:require [clj-http.client :as http-client])
  (:require [cheshire.core :refer [parse-string]])
  (:gen-class))

(def api-url "https://api.github.com/users/rafaalberto")

(defn get-profile-info []
  (:body (http-client/get api-url)))

(defn print-info [response]
  (let [{:strs [login name location followers]} response]
    (println "# GitHub Profile Info #"
         "\nUsername: " login
         "\nName: " name
         "\nLocation: " location
         "\nTotal Followers: " followers)))

(defn -main
  [& args]
  (-> (get-profile-info)
      (parse-string)
      (print-info)))
