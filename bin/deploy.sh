#!/bin/bash

# Only deploy status on master
if [ $TRAVIS_BRANCH == 'master' ]; then
  # exit with nonzero exit code if anything fails
  set -e

  # run compile script
  ./gradlew check

  cd build/reports/tests
  git init

  git config user.name "Travis CI"
  git config user.email "ragnar.valgeirsson@gmail.com"

  git add .
  git commit -m "Deploy to GitHub Pages"

  git push --force --quiet "https://${GH_TOKEN}@${GH_REF}" master:gh-pages > /dev/null 2>&1
fi