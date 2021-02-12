1. Eclipse IDE
In my case I use Java with Eclipse IDE. To install Eclipse instructions can be found on https://www.eclipse.org/downloads/packages/installer

2. TestNG
To add TestNG to Eclipse instructions can be found on https://testng.org/doc/download.html
Otherwise, you can download the TestNG jar and add it to Eclipse project as an External library.

3. Selenium Driver
This can be downloaded from https://www.selenium.dev/downloads/
Download the latest stable version. In my case https://selenium-release.storage.googleapis.com/3.141/selenium-server-standalone-3.141.59.jar

4. Webdriver
To download latest driver for Chrome we proceed to https://www.selenium.dev/downloads/, browsers section and look for Chrome. Then follow redirect and download the driver for your system. You can also get this from Maven central https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver/3.14.0

5. Running tests
Create new Java project. Add the selenium and chrome drivers as external jars to the project. Create a new TesstNG class. Write the tests, run the class as TestNG or run the project using Run button as we would normally run a Java project.
