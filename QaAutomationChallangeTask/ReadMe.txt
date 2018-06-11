********/// Project Structure Guid ///**********

QaAutomationChallangeTask

1.src/main/java
  com.test.automation.practice.config
      * config.properties (Configuration Path for Exectution of URL and Drivers)
  com.test.automation.practice.customListner 
      * Listener.java 
      * Retry.java
      * RetryListener.java
      * WebEventListener.java
  com.test.automation.practice.data	
      * TestData.xlsx
  com.test.automation.practice.excelReader
      * Excel_Reader.java
  com.test.automation.practice.report
      * ExtentReport.java
  com.test.automation.practice.testBase
      * TestBase.java
  com.test.automation.practice.uiActions
      * HomePage_AutomationPractices.java
      * HomePage.java
      * Login.java
      * OrderProccessing.java
      * ProductDetails_AutomationPractices.java
      * ProductDetailsPage.java
      * ShoppingCartPage_AutomationPractices.java
      * SignIn.java
2.src/test/java
  com.test.automation.practice.addToCartOrderProccesing
     * TC001_VerifyAaddToCart.java
     * TC002_OrderProccessing.java
  com.test.automation.practice.homepage
     * TC001_VerifyLoginWithInvalidCredentailsToAutoMationPractices.java
     * TC002_VerifyLogin.java
     * TC003_VerifyLoginWithDifferentRecords.java
     * TC004_VerifySignIn.java
3.drivers
4.Screenshots
5.automation.out
6.log4j.properties-
7.pom.xml
8.testNG.xml



***************// Project Structure Appraoch Or Framework //**********************
This project is developed in Page Object Factory Pattern.

***************// Exectution Guide //**************************

1.Install JDK 1.8
2.Install Eclipse
3.Istall Maven in Eclipse
4.Install JUNIT
6.Install TestNg
7.Import the project
8.Go to the (src/test/java) here is define two Packges (addToCartOrderProccesing and homepage) and you can execute the Testcase
9.If you need to Run the TestNG Suit you Can directly hit the ( testNG.xml) and all the TestWill executed.