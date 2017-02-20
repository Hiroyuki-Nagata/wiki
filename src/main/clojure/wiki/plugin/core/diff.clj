(ns wiki.plugin.core.diff
  (:gen-class true)
  (:use
   clojure.tools.logging
   clj-logging-config.log4j)
  (:require [wiki.default-storage :as db]
            [wiki.wiki :as wiki]))

(defn do-action [wiki]
  "Diff !")

(defn hook []
  (debug "Hello, Hook !!!???"))
