(ns github-client.report)

(defn get-report [response]
  (let [{:strs [name bio location followers]} response]
    (str "# GitHub Profile Info #"
             "\nName: " name
             "\nBio: " bio
             "\nLocation: " location
             "\nTotal Followers: " followers)))