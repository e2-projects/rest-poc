[![Build](https://github.com/e2-projects/rest-poc/actions/workflows/action-build.yml/badge.svg?branch=dev)](https://github.com/e2-projects/rest-poc/actions/workflows/action-build.yml)
[![Tests](https://github.com/e2-projects/rest-poc/actions/workflows/action-test.yml/badge.svg?branch=dev)](https://github.com/e2-projects/rest-poc/actions/workflows/action-test.yml)

# REST POC
## Description
Initial REST application to fast start with new projects.
#### Uses:
* **Java** 11
* **Groovy** 3.0.7
* **Maven** 3.6.3
* **Spring-boot** 2.4.2
* **Spock** 2.0-M4-groovy-3.0
---
## Run application
1. Open terminal
2. Download project `git clone https://github.com/e2-projects/rest-poc.git`
3. Set Project SDK to Java 11
4. Build project `mvn clean install`
5. Run application `mvn spring-boot:start`
---
## Local environment
* [Swagger](http://localhost:8081/demo/api/v1/swagger-ui/#/)
* [Database console](http://localhost:8081/demo/api/v1/h2-console)
```textmate
http://localhost:8081/demo/api/v1/ping    (GET)
http://localhost:8081/demo/api/v1/person  (POST/PUT/GET)
```
