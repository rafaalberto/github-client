(ns github-client.core
  (:require [clj-http.client :as http-client])
  (:require [cheshire.core :refer [parse-string]])
  (:gen-class))

(def api-url "https://api.github.com/users/")

(defn get-profile-info [username]
  (:body (http-client/get
           (str api-url (first username)))))

(defn print-info [response]
  (let [{:strs [name location followers]} response]
    (println "# GitHub Profile Info #"
             "\nName: " name
             "\nLocation: " location
             "\nTotal Followers: " followers)))

(defn -main
  [& args]
  (-> (get-profile-info args)
      (parse-string)
      (print-info)))