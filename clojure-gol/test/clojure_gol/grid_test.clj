(ns clojure-gol.grid-test
  (:require [clojure.test :refer :all]
            [clojure-gol.grid :refer :all]))

(deftest generation-of-grid
  (testing "grid is created with given size"
    (is (= (generate-grid 1) [[:dead]]))
    (is (= (generate-grid 2) [[:dead :dead] [:dead :dead]]))))

(deftest cells-at-given-indexes-are-set-to-live
  (testing "cells are set to live at given indexes"
    (is (= (set-live-cells [:dead] [0]) [:live]))
    (is (= (set-live-cells [:dead :dead] [1]) [:dead :live]))))

(deftest evolve-grid-to-next-representation
  (testing "representation of grid after evolve"
    (is (= (evolve-grid [[0]]) [[:live]]))
    (is (= (evolve-grid [[0][1]]) [[:live :dead][:dead :live]]))))
