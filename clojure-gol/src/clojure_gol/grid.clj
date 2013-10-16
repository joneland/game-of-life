(ns clojure-gol.grid)

(defn generate-grid [size]
  (repeat size (vec (repeat size :dead))))

(defn evolve-grid [live-cells]
  (map (fn [row rows-live-cells] (reduce #(assoc %1 %2 :live) row rows-live-cells)) (generate-grid (count live-cells)) live-cells))
