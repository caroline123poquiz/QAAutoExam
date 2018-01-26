Pre-requisites:
1. Latest version of firefox browser, java, maven


Steps:
1. Git clone from this repository: https://github.com/caroline123poquiz/QAAutoExam.git
2. Download the geckodriver:
http://www.automationtestinghub.com/selenium-3-0-launch-firefox-with-geckodriver/
3. Update config.properties to point to your gecko driver's driver path
4. Compile and assemble the jar files by running the command below:
run mvn clean compile assembly:single
5. Run command below to execute main program:
java -jar target/kaligo-0.0.1-SNAPSHOT-jar-with-dependencies.jar