(ns clojure-gol.core-test
  (:require [clojure.test :refer :all]
            [clojure-gol.core :refer :all]))

(deftest evolution-of-cells
  (testing "live cells with fewer than two live neighbours die on next evolution"
   (is (= (evolve {:status :live :neighbours [:live :dead :dead]}) :dead)))

  (testing "live cells with two live neighbours live on next evolution"
    (is (= (evolve {:status :live :neighbours [:live :live :dead]}) :live)))

  (testing "live cells with three live neighbours live on next evolution"
    (is (= (evolve {:status :live :neighbours [:live :live :live]}) :live)))

  (testing "live cells with more than three live neighbours die on next evolution"
    (is (= (evolve {:status :live :neighbours [:live :live :live :live]}) :dead)))

  (testing "dead cells with exactly three live neighbours live on next evolution"
    (is (= (evolve {:status :dead :neighbours [:live :live]}) :dead))
    (is (= (evolve {:status :dead :neighbours [:live :live :live]}) :live))))