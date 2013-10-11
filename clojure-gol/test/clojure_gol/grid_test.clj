(ns clojure-gol.grid-test
  (:require [clojure.test :refer :all]
            [clojure-gol.grid :refer :all]))

(deftest generation-of-grid
  (testing "grid is created with given size"
    (is (= (generate-grid 1) [[:dead]]))
    (is (= (generate-grid 2) [[:dead :dead] [:dead :dead]]))))

(deftest set-given-index-to-live 
  (testing "grid is updated with :live at given index"
    (is (= (set-index-to-live [[:dead]] 0 0) [[:live]]))
    (is (= (set-index-to-live [[:dead :dead][:dead :dead]] 0 1) [[:dead :live][:dead :dead]]))))

(deftest evolve-grid-to-next-representation
  (testing "representation of grid after evolve"
    (is (= (evolve-grid [[:dead :dead][:dead :dead]] [{:row 0 :column 0} {:row 1 :column 1}]) [[:live :dead][:dead :live]]))))
