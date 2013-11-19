; The namespace declaration comes at the top of the file.
; Namespaces are named based on the file path.
(ns clojure-for-the-rubyist.core
  (:require [clojure.string :as str]))

; Commas are whitespace in Clojure. They are used for semantic separation but have no syntactic meaning,
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,

; nil, true, and false are the same as in Ruby.
; As in Ruby, everything that isn't false or nil is truthy.
nil true false


; Strings are enclosed in quotation marks and can span multiple lines.
"I'm a string (instance of java.lang.String)
and I can span multiple lines."

; Regular expressions are written as strings prepended with a #
#".*\.clj$"

; Clojure also has character literals. There's no parallel in Ruby.
\a \b \c \newline

; Integers and floats act as you'd expect.
(+ 1 3)
(+ 1.5 3.25)
; Rationals are built in.
(/ 5 20)

; Clojure keywords are similar to Ruby symbols; they are interned, evaluate to themselves, and are prefixed with a colon.
:symbol :qualified/symbol ::foo

; Clojure symbols have no parallel in Ruby, but in most cases they can be thought of as variables or constants.
'this-is-a-symbol
; The apostrophe (') is not part of the symbol but it is necessary to prevent Clojure from attempting to resolve it.

;; Clojure datatypes are immutable by default.

; Clojure vectors are like Ruby arrays. They are 0-indexed, ordered, heterogenous, and dynamicly sized.
["string" 1 2 #"foooooooo" 1/10]

; Clojure maps are like Ruby hashes.
{:key1 :val1, :key2 :val2, :key3 :val3}

; Clojure sets are part of the core while in Ruby they are part of the standard library.
#{1 2 3}

; Clojure is a LISP (LISt Processing language). The language is almost syntax-free, being written in data structures.
; The basic collection is the List. A list has a head (the first element) and a tail (another list of the remaining elements).
; Here's an extremely basic list implementation in Ruby:
;; class List
;;   attr_reader :first, :rest
;;   def initialize(*elements)
;;     @first = elements.shift
;;     @rest = List.new(*elements) unless elements.empty?
;;   end
;; end
; Unlike most things in Clojure that evaluate to themselves, lists evaluate to function calls.
; The first element is invoked with the rest of the elements as arguments.
(inc 1) ; This list calls the inc (increment) function with an argument of 1, returning 2.
'(inc 1) ; This is a quoted list which means the list and elements are unevaluated and a literal list with the symbol inc and the integer 1 are returned.

; You are used to function(args) but LISPs are written as (function args).
; def defines a var
(def the-answer 42)

; fn creates a function
(fn [guess] (if (= guess the-answer)
              "Good job!"
              "Try again!"))

; defining functions is very common
(def guess-the-answer
  (fn [guess] (if (= guess the-answer)
                "Good job!"
                "Try again!")))

; defn creates and defines a function
(defn guess-the-answer2 [guess]
  (if (= guess the-answer)
    "Good job!"
    "Try again!"))
