(defproject wiki "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :uberjar-name "wiki-clj.jar"
  :min-lein-version "2.5.3"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring/ring "1.4.0"]
                 [compojure/compojure "1.4.0"]
                 [clj-http/clj-http "2.3.0"]
                 [clj-logging-config/clj-logging-config "1.9.12"]
                 [hickory/hickory "0.7.0"]
                 [environ/environ "1.0.3"]
                 [prone/prone "0.8.2"]]
  :pom-plugins [[com.theoryinpractise/clojure-maven-plugin "1.3.8"
                 {:configuration ([:mainClass "wiki.core"]
                                  [:sourceDirectories [:sourceDirectory "src/main/clj"]]
                                  [:args "host localhost port 3000"])}
                 ]]
  :source-paths ["src/main/clojure"]
  :test-paths ["src/test/clojure"]
  :resource-paths ["resources"]
  :profiles
  {:dev {:env {:dev true }}
   :uberjar {:aot :all
             :main wiki.core}})
