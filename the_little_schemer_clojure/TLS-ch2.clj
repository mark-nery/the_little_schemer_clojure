(load "TLS-functions")

(println (lat? '(a b c)))

(println (or (null? ()) (atom? 12)))
(println (or (null? '(a b c)) (null? ())))
(println (or (null? '(a b c)) (null? '(atom))))
(println (member? 'meat '(gravy mash potatoes and meat)))
(println (member? 'meat '(meat gravy)))
(println (member? 'liver '(bagels lox)))
