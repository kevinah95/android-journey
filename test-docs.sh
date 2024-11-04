#!/bin/bash

# The website is built using MkDocs with the Material theme.
# https://squidfunk.github.io/mkdocs-material/
# It requires Python to run.
# Install the packages with the following command:
# pip install mkdocs mkdocs-material mkdocs-redirects

set -ex

# Test generating the javadoc jars
#TODO:./gradlew publishToMavenLocal

# Generate the API docs
#TODO:./gradlew dokkaHtmlMultiModule

#TODO:mv ./build/dokka/htmlMultiModule docs/4.x

# Copy in special files that GitHub wants in the project root.
cat README.md | grep -v '^\[\!\[License\]' > docs/site/docs/intro.md
cp CHANGELOG.md docs/site/docs/changelog.md
#cp CONTRIBUTING.md docs/contribute/contributing.md

# Build the site locally
cd docs/site
yarn start