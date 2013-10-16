(ns clojure-gol.grid)

(defn generate-grid [size]
  (repeat size (vec (repeat size :dead))))

(defn set-live-cells [row cells]
  (reduce #(assoc %1 %2 :live) row cells))

(defn evolve-grid [live-cells]
  (let [dead-grid (generate-grid (count live-cells))]
    (map set-live-cells dead-grid live-cells)))
