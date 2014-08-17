(ns one-function-to-rule-them-all)

(defn concat-elements [a-seq]
  (reduce concat [] a-seq))

(defn str-cat [a-seq]
  (reduce str (interpose " " a-seq)))

(defn str-cat2 [a-seq]
  (if (empty? a-seq)
    ""
    (reduce #(str % " " %2) a-seq)))

(defn my-interpose [x a-seq]
  (rest (reduce #(conj %1 x %2) [] a-seq)))

(defn my-count2 [a-seq]
  (reduce #(if (not %2)
             %2
             (inc %1)) 0 a-seq))

(defn my-count [a-seq]
  (reduce (fn [count _] (inc count)) 0 a-seq))

(defn my-reverse [a-seq]
  (reduce #(cons %2 %1) () a-seq))

(defn min-max-element [a-seq]
  (reduce (fn [min-max num]
            (cond
             (empty? min-max) [num num]
             (< num (get min-max 0)) (assoc min-max 0 num)
             (> num (get min-max 1)) (assoc min-max 1 num)
             :else min-max))
          [] a-seq))

(defn insert [sorted-seq n]
  (loop [sorted []
         rst sorted-seq]
    (cond
     (empty? rst) (seq (conj sorted n))
     (< (first rst) n) (recur (conj sorted (first rst)) (rest rst))
     :else (concat sorted [n] rst))))

(defn insertion-sort [a-seq]
  (reduce (fn [sorted val]
            (insert sorted val)) [] a-seq))


(defn parity [a-seq]
  (reduce #(if (contains? %1 %2)
             (disj %1 %2)
             (conj %1 %2)) #{} a-seq))

(defn minus
  ([x] (- x))
  ([x y] (- x y)))

(defn count-params [& args]
  (count args))

(defn my-*
  ([] 1)
  ([x] x)
  ([x & args] (* x (reduce * args))))

(defn pred-and [x]
  (fn [x] :-))

(defn my-map [f a-seq]
  [:-])


(reduce * [3])  
