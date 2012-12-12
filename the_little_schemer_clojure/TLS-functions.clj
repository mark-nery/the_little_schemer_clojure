;;; Chapter one functions

(defn atom?
  "Return true if x is an atom"
  [x]
  (not (seq? x)))

(defn null?
  "return true if x is nil or ()"
  [x]
  (or (nil? x) (= () x)))

(defn s-exp?
  "returns true if x is an S-expression"
  [x]
  (or (atom? x) (list? x)))

(defn car
  "returns first item of a list"
  [x]
  (first x))

(defn cdr
  "returns the tail of a list"
  [x]
  (rest x))

(defn eq?
  "returns true if x and y are equal"
  [x y]
  (= x y))

;;; Chapter two functions

(def lat?
  (fn [l]
    (cond
     (null? l) true
     (atom? (car l)) (lat? (cdr l))
     :else false)))

(def member?
  (fn [a lat]
    (cond
     (null? lat) false
     :else (or (eq? a (car lat))
               (member? a (cdr lat))))))

;;; Chapter three functions

(def rember
  (fn [a lat]
    (cond
     (null? lat) '()
     (eq? (car lat) a) (cdr lat)
     :else (cons (car lat) (rember a (cdr lat))))))