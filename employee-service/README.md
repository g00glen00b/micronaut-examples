# Microservice with Micronaut and GraalVM

This project demonstrates how to build a simple microservice with [Micronaut](https://micronaut.io/) and [GraalVM](https://www.graalvm.org/).

## Containerization

The native image is built within a multi-stage Docker image. Initially it uses the [GraalVM image](https://hub.docker.com/r/oracle/graalvm-ce/) to build the native image. After that, it uses the [Alpine Linux image with the GNU C library image](https://hub.docker.com/r/frolvlad/alpine-glibc/) to actually run the native image. To make sure that the database is up and running before the application container starts, the image uses [wait-for](https://github.com/Eficode/wait-for).

For container orchestration, we use [Docker compose](https://docs.docker.com/compose/). The application (and database) can be ran by using:

```
docker-compose up
```

## Datasource

The application uses [MariaDB](https://mariadb.org/). The tables are created through database migrations with [Flyway](https://flywaydb.org/). The database can be ran through Docker compose as well, by using the following command:

```
docker-compose up employee-db
```

