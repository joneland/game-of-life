(ns clojure-gol.core)

(defn evolve [{:keys [status neighbours]}]
  (let [live-neighbours (:live (frequencies neighbours))]
    (cond
      (= live-neighbours 3) :live
      (and 
        (= live-neighbours 2)
        (= status :live)) :live
      :else :dead)))
