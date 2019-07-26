(ns helper.core-test
  (:require [helper.core :as helper]
            [clojure.test :refer [deftest is testing]]))


(deftest uuid-test
  (testing "it generates a uuid"
    (is (= 36 (count (str (helper/uuid))))))

  (testing "it parses a uuid"
    (let [s "00001111-1111-1111-1111-000001111111"]
      (is (= s (str (helper/uuid s)))))))


(deftest humanize-test
  (testing "with a lower case keyword"
    (is (= "Hello" (helper/humanize :hello))))

  (testing "with a lower case keyword with a few dashes"
    (is (= "Hello world" (helper/humanize :hello-world)))))


(deftest parse-int-test
  (testing "a numeric string"
    (is (= 10 (helper/parse-int "10"))))

  (testing "nil"
    (is (nil? (helper/parse-int nil))))

  (testing "blank string"
    (is (nil? (helper/parse-int ""))))

  (testing "blank string with spaces only"
    (is (nil? (helper/parse-int "   "))))

  (testing "non-numeric string"
    (is (nil? (helper/parse-int "hello"))))

  (testing "integer"
    (is (= 10 (helper/parse-int 10)))))


(deftest map-vals-test
  (testing "nil value"
    (is (= {} (helper/map-vals inc nil))))

  (testing "empty map"
    (is (= {} (helper/map-vals inc {}))))

  (testing "regular map"
    (is (= {:a 2 :b 3} (helper/map-vals inc {:a 1 :b 2})))))


(deftest map-keys-test
  (testing "nil value"
    (is (= {} (helper/map-keys name nil))))

  (testing "empty map"
    (is (= {} (helper/map-keys name {}))))

  (testing "regular map"
    (is (= {"a" 1 "b" 2} (helper/map-keys name {:a 1 :b 2})))))


(deftest deep-merge-test
  (testing "nil value"
    (is (= nil (helper/deep-merge nil))))

  (testing "empty maps"
    (is (= {} (helper/deep-merge {} {}))))

  (testing "single level maps"
    (is (= {:a 1 :b 2} (helper/deep-merge {:a 1} {:b 2}))))

  (testing "three level maps"
    (is (= {:a1 1 :a {:b {:c 4 :d 3}}} (helper/deep-merge {:a {:b {:c 4 :d 3}}} {:a1 1})))))


(deftest kebab-case-test
  (testing "nil value"
    (is (= nil (helper/kebab-case nil))))

  (testing "empty string"
    (is (= "" (helper/kebab-case ""))))

  (testing "snake case keyword"
    (is (= :hello-world (helper/kebab-case :hello_world))))

  (testing "snake case string"
    (is (= "hello-world" (helper/kebab-case "hello_world")))))


(deftest snake-case-test
  (testing "nil value"
    (is (= nil (helper/snake-case nil))))

  (testing "empty string"
    (is (= "" (helper/snake-case ""))))

  (testing "kebab case keyword"
    (is (= :hello_world (helper/snake-case :hello-world))))

  (testing "kebab case string"
    (is (= "hello_world" (helper/snake-case "hello-world")))))
