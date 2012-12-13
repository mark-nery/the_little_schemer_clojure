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

(def firsts
  (fn [l]
    (cond
     (null? l) '()
     :else (cons (car (car l)) (firsts (cdr l))))))

(def insertR
  (fn [new old lat]
    (cond
     (null? lat) '()
     :else
     (cond
      (eq? (car lat) old) (cons old (cons new (cdr lat)))
      :else (cons (car lat) (insertR new old (cdr lat)))))))

(def insertL
  (fn [new old lat]
    (cond
     (null? lat) '()
     :else
     (cond
      (eq? (car lat) old) (cons new lat)
      :else (cons (car lat) (insertL new old (cdr lat)))))))

(def subst
  (fn [new old lat]
    (cond
     (null? lat) '()
     :else
     (cond
      (eq? (car lat) old) (cons new (cdr lat))
      :else (cons (car lat) (subst new old (cdr lat)))))))

(def subst2
  (fn [new o1 o2 lat]
    (cond
     (null? lat) '()
     :else
     (cond
      (or (eq? (car lat) o1)(eq? (car lat) o2))
      (cons new (cdr lat))
      :else (cons (car lat) (subst2 new o1 o2 (cdr lat)))))))

(def multirember
  (fn [a lat]
    (cond
     (null? lat) '()
     :else
     (cond
      (eq? (car lat) a) (multirember a (cdr lat))
      :else (cons (car lat) (multirember a (cdr lat)))))))

(def multiinsertR
  (fn [new old lat]
    (cond
     (null? lat) '()
     :else
     (cond
      (eq? old (car lat)) (cons old (cons new (multiinsertR new old (cdr lat))))
      :else (cons (car lat) (multiinsertR new old (cdr lat)))))))