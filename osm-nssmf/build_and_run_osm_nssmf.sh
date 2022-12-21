### Script for building and running the osm-nssmf

cd osm-nssmf-handler/
JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64 && mvn clean install
cd ../nssmf-app/
JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64 && mvn clean install -Dcheckstyle.skip -DskipTests
cd target/
java -jar nssmf-app-0.0.1.jar
