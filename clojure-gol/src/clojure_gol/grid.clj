(ns clojure-gol.grid)

(defn generate-grid [size]
  (repeat size (vec (repeat size :dead))))

(defn set-index-to-live [grid row column]
  (assoc grid row (assoc (grid row) column :live)))
