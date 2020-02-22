(defproject hbs "1.0.4-SNAPSHOT"
  :description "Clojure templating by Handlebars.java"
  :url "http://github.com/sunng87/hbs"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.0" :scope "provided"]
                 [org.clojure/clojurescript "1.10.597" :scope "provided"]
                 [com.github.jknack/handlebars "4.1.2"]]
  :profiles {:examples {:dependencies [[ring "1.7.1"]]
                        :main hbs.server
                        :source-paths ["examples"]
                        :resource-paths ["example-resources"]}}
  :plugins [[codox "0.8.10"]
            [lein-cljsbuild "1.1.7"]
            [lein-doo "0.1.11"]
            [lein-npm "0.7.0-rc2"]]
  :codox {:output-dir "target/codox"
          :exclude [hbs.ext]}
  :global-vars {*warn-on-reflection* true}
  :deploy-repositories {"releases" :clojars}
  :cljsbuild {:builds [{:id "core"
                        :source-paths ["src"]
                        :compiler {:optimizations :advanced
                                   :output-to "target/js/hbs.js"
                                   :output-dir "target/js/"
                                   :pretty-print true
                                   :source-map "target/js/rigui.js.map"
                                   :target :nodejs
                                   :language-in :ecmascript5
                                   :language-out :ecmascript5}}
                       {:id "test-node"
                        :source-paths ["src" "test" "doo-test"]
                        :compiler {:output-to "target/js/testable.js"
                                   :output-dir "target/js/"
                                   :main hbs.runner
                                   :target :nodejs
                                   :optimizations :none}}]}
  :npm {:dependencies [[handlebars "4.7.3"]]
        :write-package-json true})
