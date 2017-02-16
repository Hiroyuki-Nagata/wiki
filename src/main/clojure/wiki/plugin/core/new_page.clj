(ns wiki.plugin.core.new-page
  (:gen-class true)
  (:use
   clojure.tools.logging
   clj-logging-config.log4j)
  (:require [wiki.default-storage :as db]
            [wiki.wiki :as wiki]))

(defn do-action [wiki]
  (str "<form method=\"post\" action=\"" (wiki/create-url) "\">\n
    <input type=\"text\" name=\"page\" size=\"40\">
    <input type=\"submit\" value=\" 作成 \">
    <input type=\"hidden\" name=\"action\" value=\"EDIT\">
  </form>\n"))
