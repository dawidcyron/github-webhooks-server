<p align="middle"><img src="https://cdn.worldvectorlogo.com/logos/webhooks.svg" alt="Logo" width="200px"><img src="https://github.githubassets.com/images/modules/logos_page/Octocat.png" alt="Github" width="200px"></p>

<h1 style="text-align: center">GitHub Webhooks Handler</h1>

<h4 style="text-align: center">Simple HTTP server for saving GitHub webhooks payload to local database.</h4><br>

#### This application was created to provide repository list for my portfolio website https://dawidcyron.me.

## Technologies used

* Java
* Spring
* Hibernate
* MySQL

## Installation

#### For this project to work you have to set up the following environment variables: 

* PORT - the application will listen on this port (8443 recommended, because SSL is required with this project)
* SECRET - GitHub Webhooks secret used to verify requests
* MYSQL_DATABASE_URL - database URL in JDBC format
* MYSQL_DATABASE_USER - name of the user used by the app to manage database
* MYSQL_DATABASE_PASSWORD - password for the user provided by MYSQL_DATABASE_USER variable
* KEYSTORE_PASSWORD - password to KeyStore
* KEYSTORE_PATH - path to KeyStore

#### Currently this project has CORS setup for specific domain, if you want to change that, edit CrossOrigin in GithubRepositoryController

#### Follow the instruction below to get the working copy of this project on your machine:

````
# Clone this repository
git clone github.com/dawidcyron/github-webhooks-server.git

# Go into the repository
cd github-webhooks-server

# Install with Maven
mvn install
# NOTE: if you havn't configured the database yet, use
mvn install -DskipTests
````

#### You can also install pull a Docker Image from Docker Hub:

````
# This version has CORS enabled for every domain!
docker pull dawidcyron/github-webhooks-handler:1.0.0
````

