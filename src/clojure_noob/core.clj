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
  (or (= 0 1) (= "yes" "no")) ;false
  (or (= 1 1) (= "yes" "no")) ;true

  (and :free_wifi :hot_coffee) ;returns the last truthy value
  ; ^ will return hot_coffee

  ;? Naming values with def
  ;todo Binding the name failed-protagonist-names to a vector containing three strings
  ;todo Notice the difference between "binding" and "assigning"
  ;* Treat def as if it's defining constants
  (def failed-protragonise-names
    ["Larry Potter" "Doreen the Explorer" "The Incredible Bulk"])
  failed-protragonise-names ; --> "Larry Potter" "Doreen the Explorer" "The Incredible Bulk"

  ;? Function error-message which accepts a single argument, severity, it
  ;? uses that to determine which string to return 
  (defn error-message
  [severity]
  (str "OH GOD! IT'S A DISASTER! WE'RE "
       (if (= severity :mild)
         "MILDLY INCONVENIENCED!"
         (if (= severity :severe)
           "TOTALLY SKREWED!"
           "GONNA NEED A SKREWDRIVER!!"))))
  
  (println (error-message :mild)) ;--> OH GOD! IT'S A DISASTER! WE'RE MILDLY INCONVIENCED
  (println (error-message :severe))
  (println (error-message :blah))
  )