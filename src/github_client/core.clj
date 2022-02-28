(ns github-client.core
  (:require [clj-http.client :as http-client])
  (:gen-class))

(defn -main
  [& args]
  (def api-url "https://api.github.com/users/rafaalberto")
  (println "GitHub API Response: " (:body (http-client/get api-url))))
