(load "TLS-functions")

(defn expect
  "Print '.' if true Print F if false"
  [x]
  (cond
   (= x true) (println ".")
   :else (println "F")))

(expect (=
         '((how much (wood))
           could
           ((a (wood) chuck roast))
           (((chuck roast)))
           (if (a) ((wood chuck roast)))
           could chuck roast wood)
         (insertR* 'roast 'chuck '((how much (wood))
           could
           ((a (wood) chuck))
           (((chuck)))
           (if (a) ((wood chuck)))
           could chuck wood))
         ))

(expect (= '() (insertR* 'new 'old '())))
(expect (= '(left right) (insertR* 'right 'left '(left))))
(expect (= '((left right)) (insertR* 'right 'left '((left)))))
(expect (= '(left right (middle left right)) (insertR* 'right 'left '(left (middle left)))))

(expect (= 0 (occur* 'hi '())))
(expect (= 1 (occur* 'hi '(hi))))
(expect (= 0 (occur* 'hi '(bye))))
(expect (= 1 (occur* 'hi '((hi)))))
(expect (= 2 (occur* 'hi '((hi) hi))))

(expect (= '((orange)
            (split ((((orange ice)))
                    (cream (orange))
                    sherbet))
            (orange)
            (bread)
            (orange brandy))
           (subst* 'orange 'banana '((banana)
                                     (split ((((banana ice)))
                                             (cream (banana))
                                             sherbet))
                                     (banana)
                                 (bread)
                                 (banana brandy)))))

(expect (= '() (subst* 'new 'old '())))
(expect (= '(new) (subst* 'new 'old '(old))))
(expect (= '(old) (subst* 'new 'older '(old))))
(expect (= '((new)) (subst* 'new 'old '((old)))))

(expect (= '((how much (wood))
             could
             ((a (wood) pecker chuck))
             (((pecker chuck)))
             (if (a) ((wood pecker chuck)))
             could pecker chuck wood)
           (insertL* 'pecker 'chuck '((how much (wood))
             could
             ((a (wood) chuck))
             (((chuck)))
             (if (a) ((wood chuck)))
             could chuck wood))))

(expect (= '() (insertL* 'new 'old '())))
(expect (= '(left right) (insertL* 'left 'right '(right))))
(expect (= '(right-middle) (insertL* 'left 'right '(right-middle))))
(expect (= '((left right)) (insertL* 'left 'right '((right)))))

(expect (= true (member* 'chips '((potato) (chips ((with) fish) (chips))))))

(expect (= 'potato (leftmost '((potato) (chips ((with) fish) (chips))))))
(expect (= 'hot (leftmost '(((hot (tuna (and))) cheese)))))