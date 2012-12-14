(load "TLS-functions")

(println (rember 'and '(bacon lettuce and tomato)))
(println (rember 'sauce '(soy sauce and tomato sauce)))

(println (firsts '((a b) (c d) (e f))))
(println (insertR 'topping 'fudge '(ice cream with fudge for desert)))
(println (insertL 'topping 'fudge '(ice cream with fudge for desert)))
(println (subst 'topping 'fudge '(ice cream with fudge for desert)))
(println (subst2 'vanilla 'chocolate 'banana '(banana ice cream with chocolate topping)))
(println (multirember 'cup '(coffee cup tea cup and hick cup)))
(println (multiinsertR  'x 'b '(a b c b d b)))
(println (multiinsertL  'x 'b '(a b c b d b)))
(println (multisubst  'x 'b '(a b c b d b)))
