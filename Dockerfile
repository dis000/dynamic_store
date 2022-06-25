FROM adoptopenjdk:11-jre-hotspot

COPY dynamic_store-1.0-SNAPSHOT.jar /dynamic_store.jar
ADD dynamic_store-1.0-SNAPSHOT.jar dynamic_store.jar
EXPOSE 5432
ENTRYPOINT ["java","-jar","/dynamic_store.jar"]
