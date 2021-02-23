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


  ;! Data Structures
  ;? Clojure Data structure properties:
  ;!!!!!!! They are immutable
  ;* They are readable
  ;* Thye support proper value equality semantics in their implementation of equals
  ;* They provide good hash values
  ;todo numbers
  93 ;integer --> 93
  1.2 ;float --> 1.2
  1/5 ;ratio --> 1/5

  ;? Strings
  ;* Notice that Clojure only allwos double quotes to delineate strings
  "Lord Voldemort"
  "\"He who must not be name\""
  "\"Great cow of Moscow!\" - Hermes Conrad"

  ;* Also notice that Clojure doesn't have string interpolation
  ;* It only allows concatentation via the str function
  (def name "Chewbacca")
  (str "\"Uggllglglglglglglglll\" - " name)

  ;! Maps
  ;? Similar to dictionaries or hasher in other langauges
  ;? Way of associating some value with some other value
  ;* Two Kinds of maps in Clojure...Hash maps and sorted maps
  {} ;--> Just an empty map

  ;* :first-name and :last-name are keywords
  {:first-name "Charlie"
   :last-name "McFishwich"}

  (def my-hash-map
    (hash-map :a 1 :b 2))

  (get my-hash-map :b) ;--> 2

  (def my-weird-map
    {:a 0 :b {:c "ho hum"}})

  (get my-weird-map :a) ;--> 0
  (get my-weird-map :b) ;--> {:c "ho hum"}

  ;? The get-in function lets you look up values in nested maps:
  (get-in my-weird-map [:b :c]) ;--> "ho hum"

  ;? Another way to look up a value in a map is to treat the map 
  ;? like a function with the key as its arguemnt: 
  ({:name "The human coffeepot"} :name) ;--> "The human coffeepot"

  ;! Keywords
  ;? Clojure keywords are  primarily used as keys in maps
  ;? Here are some examples
  :a
  :rumplestiltsken
  :34
  :_?

  ;? Keywords can be used as functions that look up the corresponding value in a data structure
  ;? Here we look up :a in a map
  (:a {:a 1 :b 2 :c 3}) ;--> 1
  ;? Default value
  (:d {:a 1 :b 2 :c 3} "Nothing here") ;--> "Nothing here"

  ;! Vectors
  ;? Similar to an array...0 index collection
  (get [3 2 1] 0) ;--> 3

  (def my-awesome-vector
    [3 2 1])

  (get my-awesome-vector 0); --> 3

  (get ["a" {:name "Pugsley Winterbottom"} "c"] 1) ;--> {:name "Pugsley Winterbottom"}

  ;* Vector Elements can be any type
  (def my-weird-vector
    ["a" {:name "Pugsley Winterbottom"} "c"])

  (get-in my-weird-vector [1 :name])
  "Pugsley Winterbottom"

  ;* Create vectors with the vector function
  (vector "Hello" "Mr" "Blah")
  ["Hello" "Mr" "Blah"]

  ;* conj function to add additional elements to the vector
  ;* NOTE: Elements added to the end of a vector
  (conj my-weird-vector 4);--> ["a" {:name "Pugsley Winterbottom"} "c" 4]
  (println my-weird-vector);--> ["a" {:name "Pugsley Winterbottom"} "c"]

  (def my-weird-vector
    (conj my-weird-vector 4))
  (println my-weird-vector) ;--> ["a" {:name "Pugsley Winterbottom"} "c" 4]

  ;! Lists
  ;* Similar to vectors...but can't retrieve list elements with get
  ;* To create one...specify with a single quote at the beginning
  '(1 2 3 4 5) ;--> (1 2 3 4 5)

  (def my-awesome-list
    '("Pete" "Is" 3))

  ;* Nth function to retrieve an element from a list
  (nth my-awesome-list 1); --> "Is"

  ; (nth my-awesome-list 4 "YOYOYO") ;--> "YOYOYO"

  ; (nth my-awesome-list 4) ;--> nil 

  ;* List values can have any type, can create lists with the list function
  (def my-new-list
    (list 1 "two" {3 4}))

  my-new-list ;--> (1 "two" {3 4})

  ;* Elements are added to the beginngin of a list
  (conj my-awesome-list 4); --> (4 "Pete" "Is" 3)
  ;? when should I use a list vs a vector?
  ;* LIST:
    ;* When you need to easily add at the beginning of the sequence
    ;* When writing a macro
  ;* VECTOR:
    ;* Everything else
  ;    

  ;! Sets
  ;* collections of unique values
  ;* Clojure has two kinds: HASH and SORTED
  #{"contrived examples" 20 :icicle}

  ;* Can als use 'hash-set' function to create a set
  (hash-set 1 1 1 1 1 2)
  #{1 2}

  (def my-awesome-set
    #{1 2})


  ;* Notice how multiple instances of a value become one unique value in the set
  (conj my-awesome-set 2) ;* I already have a 2 in the set...so it doesn't actually add anything
  #{1 2}

  ;* We can also create sets from existing vectors and lists by using the set function
  (set [3 3 4 4])
  #{4 3}

  (def another-awesome-set
    (set ["Blarg" "Malarg"]))


  (println another-awesome-set) ;--> #{"Blarg" "Malarg"}

  ;* Check for set membership using the contains? function
  (contains? another-awesome-set "Blarg");--> true

  (contains? another-awesome-set "blarg"); --> false

  (contains? #{nil} nil); --> true

  ;* get and keyword lookup will return the value if it exists, or nil if it doesn't
  (:a #{:a :b}); --> :a

  (get #{:a :b} :a); --> :a

  ;! More on Functions
  (or + -)
  ; #function[clojure.core/+]

  ;* B/c + is a truthy value it returns the addition function which is then used as the operator in another expression
  ((or + -) 1 2 3)
  ;--> 6

  (and (= 1 1))
  ;--> true

  (and (= 1 1) +) ;* return value of and is the first falsey value or the LAST truthy value
  ; #function[clojure.core/+]

  ((and (= 1 1) +) 1 2 3)
  ;--> 6

  ((first [+ 0]) 1 2 3) ;* return value of first is the first element in a sequence
  ;--> 6

  (rest [10 20 30 40]) ;* rest function returns all the items of a sequence except the first
  ;--> [20 30 40]

  ;? Map function creats a list by applying a function to each member of a collection
  ;? Inc function increments a number by 1
  (inc 1.1); --> 2.1
  (map inc [0 1 2 3]); --> (1 2 3 4)

  ;? Filter function returns a sequence of items on the collection where the operator returns logically true
  (filter even? (range 10)); --> (0 2 4 6 8)
  (filter #(> % 5) '(3 4 5 6 7)); --> (6 7)


  ;* Clojure evaluates all function arguments recursively before passing them to a function
  ; (+ (inc 199) (/ 100 (- 7 2)))
  ; (+ 200 (/ 100 (- 7 2))) ; evaluated "(inc 199)"
  ; (+ 200 (/ 100 5)) ; evaluated (- 7 2)
  ; (+ 200 20) ; evaluated (/ 100 5)
  ; 220 ; final evaluation
  (+ (inc 199) (/ 100 (- 7 2)))
  220
  ;! Function Calls, Macro Calls, and Special Forms
  ;* Two other types of expressions are macro calls and specials forms
  ;* If expressions and definitions are both special forms
  ;? What makes specials forms 'special' --> They don't always eval all their operands


  ;! Defining functions
  ;* Five main parts
  ; defn, function name, docstring describing the function (optional), params in brackets, function body)
  (defn my-amazing-function
    "Returns an absolutely amazing string"
    [name]
    (str "Hey " name " you are amazing"))

  (my-amazing-function "Clojure"); --> "Hey Clojure you are amazing"

  ; (doc my-amazing-function)

  ;! Parameters and Arity
  ; function with 0 parameters is a 0 arity function, 1 parameter is 1-arity and so on

  (defn zero-arity
    "Function with 0-arity"
    []
    "I take nothing")
  (defn one-arity
    "Function with 1-arity"
    [x]
    (str "I take one parameter " x))
  (defn two-arity
    "Function with 2-arity"
    [x y]
    (str "I take parameters " x y))
  ;? Arity overloading
  ;* Defining a function so a different function body will run depending on the arity
  ;* One way of providing default values for arguments
  (defn x-chop
  ;3-arity argument body
    ([name chop-type]
     (str "I " chop-type " chop " name " ! Take that!"))
    ([name]
     (x-chop name "karate")))
  (x-chop "Pete");--> "I karate chop Pete ! Take that!"

  (x-chop "Pete" "ninja"); --> "I ninja chop Pete ! Take that!" 
  ;? Also allows you to define a function that does completely 
  ;? unrelated things depending on how many arguments are given

  (defn weird-arity
    "Function that returns a sentence if 0 arguments given, or increases a number otherwise"
    ([]
     "Hello...says this wierd arity function")
    ([x]
     (inc x)))
  (weird-arity) ;-> "Hello...says this wierd arity function"

  (weird-arity 1) ;-> 2

  ;? Variable arity with the rest parameter
  ;* can define variable arity functions by including a rest parameter
  ;* puts the rest of the arguments in a list with the given name...using the &
  (defn ill-tell-you-what
    [name]
    (str "Let me tell you what " name " , I won't stand for this!!"))

  (defn mr-rodgers
    [& names] ;* Where the magic happens
    (map ill-tell-you-what names))

  (mr-rodgers "Blarg" "Chewy" "Aaron")
  ;; ("Let me tell you what Blarg , I won't stand for this!!"
  ;;  "Let me tell you what Chewy , I won't stand for this!!"
  ;;  "Let me tell you what Aaron , I won't stand for this!!")

  ;? Can mix rest parameters with normal parameters, but the rest params have to come last
  (defn some-stuff
    [name & stuff]
    (str "Hello, " name " here is some free stuff: "
         (clojure.string/join ", " stuff)))

  (some-stuff "Blarg" "Television" "X-box" "PS-5")
  "Hello, Blarg here is some free stuff: Television, X-box, PS-5"

  ;! Let keyword
  ;* Another special form in Clojure
  ;* Provides a way to create lexical bindings of data structures to symbols

  (let [x 1] (+ 2 x)) ;--> 3
  (let [myVar 1] (/ 5 myVar)) ; --> 5 

  (let [firstVar "Blarg" secondVar "Malarg"] (str firstVar " " secondVar)) ; --> "Blarg Malarg"

  ;! Reduce
  ;* Takes a two argument function and an optional starting point val
  ;* If val is not supplied, returns the result of applying f to the first 2 items
  (println (reduce + [1 2 3 4 5])) ; ==> 15
  (def my-reduce-var
    (reduce + [1 2 3 4]))
  (println my-reduce-var) ;--> 10
  (reduce + 1 [2 3]); --> 6

  ;! dec function
  ;* Returns a number one less than the number.
  (println (dec 2)) ;--> 1

  ;! Destructuring
  ;? more sophiscated way of defining parameters
  ;* Concisely lets you bind names to values within a collection
  (defn my-first
    [[first-thing]]
    first-thing)
)