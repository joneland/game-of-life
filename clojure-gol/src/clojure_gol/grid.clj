(ns clojure-gol.grid)

(defn generate-grid [size]
  (repeat size (vec (repeat size :dead))))

(defn set-live-cells [row cells]
  (reduce #(assoc %1 %2 :live) row cells))

(defn evolve-grid [indexes-of-live-cells]
  (let [dead-grid (generate-grid (count indexes-of-live-cells))]
    (map set-live-cells dead-grid indexes-of-live-cells)))
