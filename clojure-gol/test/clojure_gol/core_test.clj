(ns clojure-gol.core-test
  (:require [clojure.test :refer :all]
            [clojure-gol.core :refer :all]))

(deftest evolution-of-cells
  (testing "live cell with fewer than two live neighbours dies on next evolution"
   (is (= (evolve {:status :live :neighbours [:live :dead :dead]}) :dead)))

  (testing "live cell with two live neighbours lives on next evolution"
    (is (= (evolve {:status :live :neighbours [:live :live :dead]}) :live)))

  (testing "live cell with three live neighbours lives on next evolution"
    (is (= (evolve {:status :live :neighbours [:live :live :live]}) :live)))

  (testing "live cell with more than three live neighbours dies on next evolution"
    (is (= (evolve {:status :live :neighbours [:live :live :live :live]}) :dead)))

  (testing "dead cell with exactly three live neighbours lives on next evolution"
    (is (= (evolve {:status :dead :neighbours [:live :live]}) :dead))
    (is (= (evolve {:status :dead :neighbours [:live :live :live]}) :live))))
