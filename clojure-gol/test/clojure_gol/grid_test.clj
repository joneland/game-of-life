(ns clojure-gol.grid-test
  (:require [clojure.test :refer :all]
            [clojure-gol.grid :refer :all]))

(deftest generation-of-grid
  (testing "grid is created with given size"
    (is (= (generate-grid 1) [[:dead]]))
    (is (= (generate-grid 2) [[:dead :dead] [:dead :dead]]))))
