(ns simple-ring.app
  (:use compojure.core
        ring.adapter.jetty
        ring.middleware.nested-params
        ring.middleware.reload)
  (:require [compojure.route :as route]))

(defroutes main-routes
  (GET "/"
       request {:body (str (:params request))}))

(def app
     (-> #'main-routes
         (wrap-reload '[simple-ring.app])
         (wrap-nested-params)))
