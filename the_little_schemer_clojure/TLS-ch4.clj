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

(expect (= 3 (quotient 15 4)))

(expect (= 6 (length '(hotdogs with mustard sauerkraut and pickles))))
(expect (= 'macaroni (pick 4 '(lasagna spaghetti ravioli macaroni meatball))))

(expect (= '(hotdogs with mustard) (rempick 3 '(hotdogs with hot mustard))))
(expect (= '(pears prunes dates) (no-nums '(5 pears 6 prunes 9 dates))))
(expect (= '(5 6 9) (all-nums '(5 pears 6 prunes 9 dates))))

(expect (= true (eqan? 1 1)))
(expect (= false (eqan? 1 "string")))
(expect (= false (eqan? 1 2)))
(expect (= true (eqan? "string" "string")))

(expect (= 3 (occur 3 '(1 3 2 3 3))))

(expect (= '(lemon meringue pie) (rempick 3 '(lemon meringue salty pie))))