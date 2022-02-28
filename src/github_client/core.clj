(ns github-client.core
  (:require [clj-http.client :as http-client])
  (:require [cheshire.core :refer [parse-string]])
  (:require [clojure.tools.cli :refer [parse-opts]])
  (:gen-class))

(def base-url "https://api.github.com/users/")

(defn get-profile-info [username]
  (prn "username: " username)
  (:body (http-client/get
           (str base-url username))))

(defn print-info [response]
  (let [{:strs [name location followers]} response]
    (println "# GitHub Profile Info #"
             "\nName: " name
             "\nLocation: " location
             "\nTotal Followers: " followers)))

(defn read-options [arguments]
  (:options (parse-opts arguments
                        [["-u" "--username name"]])))

(defn -main
  [& args]
  (let [{:keys [username]} (read-options args)]
    (-> (get-profile-info username)
        (parse-string)
        (print-info))))