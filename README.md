# Cucumber_RestAssured_Framework
Framework to test Users API using cucumeber and RestAssured

This project is used to validate responses to the users api endpoint

It uses cucumber feature files to define the test scenarios. The API requests are submitted and validated using a Step definiton file incorporating the RestAssured library to validate details contained in json response body. 

#### How to download project from Github to Intellij

I performed the following steps using IntelliJ IDEA 2021.3.2 (Community Edition) but should be applicable for other versions

1. Navigate to the Github repo page (you will need to have been granted access to this) and select Download Zip from the Code drop down to download the zip file to your local machine.
2. Unzip the project file to your chosen project directory.
3. Open Intellij and select New > Project From Existing Sources.
4. From the file explorer select the project you unzipped (step 2).
5. Check the Import Project from External Mode.
6. Click Finish and then Trust Project.
7. Wait for the project to  build in Intellij.

#### How to execute the tests
  
The feature files can be executed in 2 ways. Firstly from the mainRunner class. Creating a main runner class allows us to target/execute specific feature files as well as incorporating reporting into the solution.
  
To run the  MainRunner class open this class in Intellij (src/test/java/runners/MainRunner.java) and click on the arrow next to 'public class MainRunner' and select Run MainRunner. The tests will execute and results will be recorded in the Intellij console. Additionally a report will be generated in target/cucumber-report.html, which can be opened in a browser. The report will indicate which tests passed or failed, and if failed what the actual response received was vs the expected response.
  
 Alternatively you can right click  on feature file from the project explorer navigation on left hand side and select 'Run Feature'. In this case the test execution will show in the Intellij console but a report will not be generated.
