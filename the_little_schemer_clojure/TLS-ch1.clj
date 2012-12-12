(load "TLS-functions")

(println (atom? 'atom))
(println (atom? 'turkey))
(println (atom? 1492))
(println (atom? 'u))
(println (atom? '*abc$))
(println (list? '(atom)))
(println (list? '(atom turkey or)))
(println (list? '((atom turkey)or)))


(println (s-exp? 'xyz))
(println (s-exp? '(x y z)))
(println (s-exp? '('(x y)z)))

(println (list? '(how are you doing so far)))
(println (list? ()))

(println (atom? ()))


(println (car '(a b c)))
(println (car '((abc)x y z)))
(println (car ()))
(println (car '(((hotdogs)) (and) (pickle)relish)))
(println (car(car '(((hotdogs)) (and) (pickle)relish))))


(println (cdr '(a b c)))
(println (cdr '((a b c )x y z)))
(println (cdr '(hamburger)))
(println (cdr '((x)t r)))
(println (car (cdr '((b) (x y) ((c))))))

(println (cons 'peanut '(butter and jelly)))
(println (cons '(bannana and) '(peanut butter and jelly)))
(println (cons '((help)this) '(is very ((hard)to learn))))
(println (cons '(a b (c)) ()))
(println (cons 'a (car '((b)c d))))
(println (cons 'a (cdr '((b)c d))))

(println (null? (quote ())))
(println (null? '(a b c)))

(println (atom? "Harry"))
(println (atom? (car '(Harry and a heap of apples))))
(println (atom? (cdr '(Harry and a heap of apples))))
(println (atom? (cdr '(Harry))))
(println (atom? (car (cdr '(swing low sweet cherry oat)))))
(println (atom? (car (cdr '(swing (low sweet) cherry oat)))))


(println (eq? 'Harry 'Harry))
(println (eq? 'margarine 'butter))
(println (eq? () '(strawberry)))
(println (eq? 6 7))
(println (eq? (car '(Mary had a little lamb) )'Mary))
(println (eq? (cdr '(soured milk))'milk))
(println (eq? (car '(beans beans we need jelly beans)) (car (cdr '(beans beans we need jelly beans)))))