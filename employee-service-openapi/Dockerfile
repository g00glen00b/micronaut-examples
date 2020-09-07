FROM oracle/graalvm-ce:20.1.0-java11 as graalvm
RUN gu install native-image

COPY . /home/app/employee-service
WORKDIR /home/app/employee-service

RUN native-image --no-server -cp build/libs/employee-service-*-all.jar

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/employee-service/employee-service /app/employee-service
COPY wait-for /app/wait-for
CMD /app/wait-for $DATABASE_HOST:$DATABASE_PORT -t 15 -- /app/employee-service
