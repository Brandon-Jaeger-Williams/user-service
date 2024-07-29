# UserService

This project was tested in java version 21

## Setup Database

I am using a docker image for the postgres database, so you can run the below command

Run `podman run --name postgres-container -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 postgres`

## Start up application

please run `mvn clean install` and then run `mvn spring-boot:run -Dspring-boot.run.profiles=local`

## Test Users

You can use test users "User1", "User2" and "User3". The password for all 3 users is "Password123"

## Running unit tests

Run `mvn test` to kick off the unit tests