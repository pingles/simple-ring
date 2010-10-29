(use 'ring.adapter.jetty)
(require 'simple-ring.app)

(let [port (Integer/parseInt (get (System/getenv) "PORT" "8080"))]
  (run-jetty #'simple-ring.app/app {:port port}))
 
