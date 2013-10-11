(ns clojure-gol.grid)

(defn generate-grid [size]
  (repeat size (vec (repeat size :dead))))

(defn set-index-to-live [grid row column]
  (assoc grid row (assoc (grid row) column :live)))

(defn evolve-grid [grid live-cells]
  (loop [cells live-cells
         evolved-grid grid]
    (if (empty? cells)
      evolved-grid
      (recur (rest cells)
             (set-index-to-live evolved-grid ((first cells) :row) ((first cells) :column))))))
