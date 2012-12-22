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

(def multiinsertL
  (fn [new old lat]
    (cond
     (null? lat) '()
     :else
     (cond
      (eq? old (car lat)) (cons new (cons old (multiinsertL new old (cdr lat))))
      :else (cons (car lat) (multiinsertL new old (cdr lat)))))))

(def multisubst
  (fn [new old lat]
    (cond
     (null? lat) '()
     :else
     (cond
      (eq? old (car lat)) (cons new (multisubst new old (cdr lat)))
      :else (cons (car lat) (multisubst new old (cdr lat)))))))

;;; Chapter 4 functions
(def add1
  (fn [n]
    (+ 1 n)))

(def sub1
  (fn [n]
    (- n 1)))

(def +
  (fn [n m]
    (cond
     (zero? m) n
     :else (add1 (+ n (sub1 m))))))

(def -
  (fn [n m]
    (cond
     (zero? m) n
     :else (sub1 (- n (sub1 m))))))

(def tup?
  (fn [tup]
    (cond
     (null? tup) true
     (not (number? (car tup))) false
     :else (tup? (cdr tup)))))

(def addtup
  (fn [tup]
    (cond
     (null? tup) 0
     :else (+ (car tup) (addtup (cdr tup))))))

(def quotient
  (fn [n m]
    (cond
     (< n m) 0
     :else (add1 (quotient (- n m) m)))))

(def length
  (fn [lat]
    (cond
     (null? lat) 0
     :else (add1 (length (cdr lat))))))

(def pick
  (fn [n lat]
    (cond
     (zero? (sub1 n)) (car lat)
     :else (pick (sub1 n) (cdr lat)))))

(def no-nums
  (fn [lat]
    (cond
     (null? lat) '()
     :else
     (cond
      (number? (car lat)) (no-nums (cdr lat))
      :else (cons (car lat) (no-nums (cdr lat)))))))

(def all-nums
  (fn [lat]
    (cond
     (null? lat) '()
     :else
     (cond
      (number? (car lat)) (cons (car lat) (all-nums (cdr lat)))
      :else (all-nums (cdr lat))))))

(def eqan?
 (fn [a1 a2]
   (cond
    (and (number? a1) (number? a2)) (= a1 a2)
    (or (number? a1) (number? a2)) false
    :else (eq? a1 a2))))

(def occur
  (fn [a lat]
    (cond
     (null? lat) 0
     :else
     (cond
      (eq? a (car lat)) (add1 (occur a (cdr lat)))
      :else (occur a (cdr lat))))))

(def one?
  (fn [n]
    (= n 1)))

(def rempick
  (fn [n lat]
    (cond
     (one? n) (cdr lat)
     :else (cons (car lat) (rempick (sub1 n) (cdr lat))))))

;;; Chapter five functions

(def rember*
  (fn [a l]
    (cond)
    (null? l) '()
    (atom? (car l))
    (cond
     (eq? a (car l)) (rember* a (cdr l))
     :else (cons (car l) (rember* a (cdr l))))
    :else (cons (rember* a (car l)) (rember* a (cdr l)))))

(def insertR*
  (fn [new old l]
    (cond
     (null? l) '()
     (atom? (car l))
     (cond
      (eq? old (car l)) (cons old (cons new (insertR* new old (cdr l))))
      :else (cons (car l) (insertR* new old (cdr l))) )
     :else (cons (insertR* new old (car l)) (insertR* new old (cdr l))))))

(def occur*
  (fn [a l]
    (cond
     (null? l) 0
     (atom? (car l))
     (cond
      (eq? a (car l)) (add1 (occur* a (cdr l)))
      :else (occur* a (cdr l)))
     :else (+ (occur* a (car l)) (occur* a (cdr l))))))

(def subst*
  (fn [new old l]
    (cond
     (null? l) '()
     (atom? (car l))
     (cond
      (eq? old (car l)) (cons new (subst* new old (cdr l)))
      :else (cons (car l) (subst* new old (cdr l))))
     :else (cons (subst* new old (car l)) (subst* new old (cdr l))))))

(def insertL*
  (fn [new old l]
    (cond
     (null? l) '()
     (atom? (car l))
     (cond
      (eq? old (car l)) (cons new (cons old (insertL* new old (cdr l))))
      :else (cons (car l) (insertL* new old (cdr l))))
     :else (cons (insertL* new old (car l)) (insertL* new old (cdr l))))))

(def member*
  (fn [a l]
    (cond
     (null? l) '()
     (atom? (car l))
     (or (eq? a (car l)) (member* a (cdr l)))
     :else (or (member* a (car l)) (member* a (cdr l))))))

(def leftmost
  (fn [l]
    (or(atom? (car l)) (car l)
       (leftmost (car l)))))