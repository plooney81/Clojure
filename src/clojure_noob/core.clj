(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I'm a little teapot")

  ;? Mathmatical expression
  (println (* (+ 1 2) (+ 2 3))) ; 3 * 5 = 15

  ;? if expression
  ;*   (if boolean-form
  ;*     then-form
  ;*     optional-else-form)
  (if true
    "True form" ;can have only one form for each branch
    "Else form") ;

  ;? to get around the fact that we can have only one form for each branch
  ;? we can use the do operator
  (if true
    (do (println "Success!")
        "Blah")
    (do (println "Failure!")
        "Another blah"))
  ;? When operator --> combo of if and do...w/o an else branch
  (when true
    (println "Success!")
    "Abra cadabra")

  ;? nil, true, false, Truthiness, Equality, and Boolean Expressions
  ;? nil is used to represent no value in clojure...check if a value
  ;? is nil by using the nil? function
  (println (nil? 1)) ;false
  (println (nil? nil)) ;true
  (if nil
    "this won't be the result because nil is falsey"
    "nil is falsey")

  ;? equality operator
  (= 1 1) ;true
  (= nil nil) ;true
  (= 1 1 2) ;false
  
  ;?boolean expressions
  (or (= 0 1)(= "yes" "no")) ;false
  (or (= 1 1)(= "yes" "no")) ;true

  (and :free_wifi :hot_coffee) ;returns the last truthy value
  ; ^ will return hot_coffee
  
  
)