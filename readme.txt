#download geckodriver
#update config.properties to point to your gecko driver



#compile and assemble the jar files
run mvn clean compile assembly:single

#run command to execute main program
java -jar target/kaligo-0.0.1-SNAPSHOT-jar-with-dependencies.jar
