(ns github-client.report)

(defn get-report [response]
  (let [{:strs [name location followers]} response]
    (println "# GitHub Profile Info #"
             "\nName: " name
             "\nLocation: " location
             "\nTotal Followers: " followers)))