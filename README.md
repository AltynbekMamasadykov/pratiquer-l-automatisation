mvn "-Dbrowser=chrome" "-Denvironment=dev" "-Dsurefire.suiteXmlFiles=src/test/resources/testng-all.xml" clean test
mvn "-Dbrowser=chrome" "-Denvironment=qa" "-Dsurefire.suiteXmlFiles=src/test/resources/testng-all.xml" clean test
mvn  "-Dbrowser=chrome" "-Denvironment=dev" "-Dsurefire.suiteXmlFiles=src/test/resources/testng-smoke.xml" clean test
mvn  "-Dbrowser=chrome" "-Denvironment=qa" "-Dsurefire.suiteXmlFiles=src/test/resources/testng-smoke.xml" clean test
