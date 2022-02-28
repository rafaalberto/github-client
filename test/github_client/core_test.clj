(ns github-client.core-test
  (:require [clojure.test :refer :all]
            [github-client.core :refer :all]))

(deftest success-test
  (testing "I am OK."
    (is (= 1 1))))

(deftest fail-test
  (testing "FIXME, I fail."
    (is (= 0 1))))
