(load "TLS-functions")

(defn expect
  "Print '.' if true Print F if false"
  [x]
  (cond
   (= x true) (println ".")
   :else (println "F")))

(expect (= 68 (add1 67)))
(expect (= 2 (sub1 3)))
(expect (= 3 (+ 1 2)))
(expect (= 1 (- 5 4)))

(expect (= true (tup? '())))
(expect (= true (tup? '(3))))
(expect (= true (tup? '(2 11 3 79 47 6))))
(expect (= false (tup? '(1 2 8 apple 4 3))))
(expect (= false (tup? '(3 '(7 4) 13 9))))

(expect (= 0 (addtup '())))
(expect (= 1 (addtup '(1))))
(expect (= 18 (addtup '(3 5 2 8))))

(expect (= 12 (x 2 6)))

(expect (= '(7 13) (tup+ '(3 7 ) '(4 6))))
(expect (= '(7 13 8 1) (tup+ '(3 7 ) '(4 6 8 1))))

(expect (= true (> 1 0)))
(expect (= false (> 0 1)))
(expect (= false (> 0 0)))