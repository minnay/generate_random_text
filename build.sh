#!/bin/bash

set -e

mkdir -p out
javac -d out -cp src src/Main.java
find test | grep java | xargs -n 1 javac -d out -cp out:src:junit-4.7.jar
pushd out
jar cfe ../app.jar Main **
popd
java -cp out:junit-4.7.jar org.junit.runner.JUnitCore exercise.TestSuite