(ns clojure-gol.grid)

(defn generate-grid [size]
  (repeat size (vec (repeat size :dead))))
