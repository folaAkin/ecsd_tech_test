# ecsd_tech_test
- This repository contains Java classes, cucumber feature file that provide solution to ECS Digital Test.
 -In order to run this test, the following tools must be installed on the machine where the test will be run. Java,Maven,Cucumber-jvm,git,chrome driver, gecko driver for mac or 32 chrome driver and gecko driver for windows.
- Clone the project by downloading the zip file or run git clone https://github.com/folaAkin/ecsd_tech_test.git
- Then run "mvn clean install" ( go to the directory where the project is cloned or downloaded to before running the command).
- To run the test from commandline, 'mvn test' runs all the test, to run on a specific browser 'mvn test -Dbrowser=chrome or - firefox'.
- The test can be run from the Cucumber Test Runner class by right clicking and run.
- The test can also be run from the feature file by right clicking on the feature or to run a specific scenario, right click on the scenario.
- To view the test report,when the test runs, the reports will be generate in the reports folder.Two reports will be generated,one is in the cucumber-reports sub folder and the other is in the cucumber-pretty sub folder.Open .html reports in a browser of choice

