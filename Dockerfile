FROM java:8

ADD . /tmp/app

WORKDIR /tmp/app

RUN ./gradlew build &&\
	cp ./build/libs/news-service-0.1.0.jar app.jar

RUN bash -c 'touch app.jar'

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]



	