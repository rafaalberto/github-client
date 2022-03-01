(ns github-client.client
  (:require [clj-http.client :as http-client])
  (:require [cheshire.core :refer [parse-string]]))

(def base-url "https://api.github.com/users/")

(defn get-profile [username]
  (-> (:body (http-client/get (str base-url username)))
      (parse-string)))