(ns clojure-for-the-rubyist.async.burning-books
  "Based on Rob Pike's 'Concurrency Is Not Parallelism' talk.
  http://talks.golang.org/2012/waza.slide#12"
  (:require [clojure.string :as str]
            [clojure.core.async :as csp]))

(def books (for [lang  (str/split-lines (slurp "resources/programming_languages"))
                 title ["%s Inside Out"
                        "%s for Fun and Profit"
                        "%s: The Definitive Guide"
                        "%s: The Good Parts"
                        "Deploying %s Applications"
                        "Essential %s"
                        "Practical %s"
                        "Real World %s"
                        "Test-Driven Development with %s"
                        "Web Development with %s"
                        "Zen and the Art of Programming %s"]]
             (format title lang)))

(defn burn-baby-burn
  "Transports and burns books asynchronously.
  Returns immediately."
  []
  (let [cart (csp/chan)]
    (csp/go (doseq [book books]
              (Thread/sleep (rand-int 100))
              (println (format "Moving: \"%s\"" book))
              (csp/>! cart book))
            (csp/close! cart))
    (csp/go (loop [book (csp/<! cart)]
              (Thread/sleep (rand-int 100))
              (when book
                (println (format "Burning: \"%s\"" book))
                (recur (csp/<! cart)))))))
