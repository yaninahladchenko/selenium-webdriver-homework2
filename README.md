To setup Edge driver for Selenium:
1. Fix windows registry as described here https://github.com/julienvollering/MIAmaxent/issues/1
2. Note that WebDriverManager does not support Edge because of issue https://github.com/bonigarcia/webdrivermanager/issues/338
3. Check your Edge version and download corresponding version of MicrosoftWebDriver.exe here https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/#downloads
4. Put downloaded MicrosoftWebDriver.exe to resources folder 
5. Use following code lines to set path to MicrosoftWebDriver.exe before creation of new EdgeDriver()
String pathToEdgeDriver = getClass().getClassLoader().getResource("driver/MicrosoftWebDriver.exe").getPath();
System.setProperty("webdriver.edge.driver", pathToEdgeDriver);
(as explained here https://www.mkyong.com/java/java-read-a-file-from-resources-folder/ to avoid hardcoded path)
