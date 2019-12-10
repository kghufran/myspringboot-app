# myspringboot-app

Simple CRUD operation using Springboot + MySql + JPA + Hibernate Restful API

## Requirement

Jave 1.8.*

Maven 3.*

MySql 5.6.*

# Setup

## Clone repo:

git clone https://github.com/kghufran/myspringboot-app.git

## Create database in MySql

create database springbootapp

## Set mysql username and password

open src/main/resources/application.properties

## Run application using maven

mvn spring-boot:run

app will be running at http://localhost:8080

## Rest endpoints

GET /persons

POST /persons

GET /persons/{id}

PUT /persons/{id}

DELETE /persons/{id}


Test it using postman or any other rest client

