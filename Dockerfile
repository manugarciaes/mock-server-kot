FROM gradle:6.7-jdk8

RUN mkdir -p ./app/
WORKDIR /app

COPY . .

RUN ./gradlew build -x test
EXPOSE 8080
ENTRYPOINT ["gradle","run"]