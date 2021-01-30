(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I'm a little teapot")

  ; Mathmatical expression
  (println (* (+ 1 2)(+ 2 3))) ; 3 * 5 = 15

  ; if expression
  ;   (if boolean-form
  ;     then-form
  ;     optional-else-form)
  (if true
    "True form" ;can have only one form for each branch
    "Else form") ;
  
  ; to get around the fact that we can have only one form for each branch
  ; we can use the do operator
  (if true
    (do (println "Success!")
        "Blah")
    (do (println "Failure!")
        "Another blah"))
  
) 
