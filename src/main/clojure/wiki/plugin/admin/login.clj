(ns wiki.plugin.admin.login
  (:gen-class true)
  (:use
   clojure.tools.logging
   wiki.view.login)
  (:require [clojure.string :refer [blank?]]
            [wiki.default-storage :as db]
            [wiki.wiki :as wiki]))

(defn default [req]
  (debug "Called login/default")
  (let [page-name (:page (wiki/params))]
    (login-tmpl (wiki/create-url) page-name)))

(defn do-action [req]
  (debug "Called login/do-action")
  (let [params (wiki/params)
        id (or (:id params) "")
        pass (or (:pass params) "")]
    (if (wiki/login id pass)
      ;; ログイン成功
      (let [se (wiki/sessions)
            update-se (merge se {:wiki_id id})]
        (wiki/update-local-state :session update-se)
        (debug (str "Succeed to login, user: " id))
        "Succeed to login !")
      ;; ログインしていないのでログインフォームへ
      (default req))))
