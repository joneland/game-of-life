(ns clojure-gol.core)

(defn evolve [cell]
  (let [live-neighbours (:live (frequencies (:neighbours cell)))]
    (cond
      (= live-neighbours 3) :live
      (and 
        (= live-neighbours 2)
        (= (:status cell) :live)) :live
      :else :dead)))