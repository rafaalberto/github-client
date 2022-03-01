(ns github-client.options
  (:require [clojure.tools.cli :refer [parse-opts]]))

(defn read-options [arguments]
  (:options (parse-opts arguments
                        [["-u" "--username name"]])))