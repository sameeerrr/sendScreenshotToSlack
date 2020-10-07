# Send Screenshot To Slack On Test Case Failure

This Program helps you to send an alert message along with the screenshot using Selenium and Slack incoming webhook whenever a test case fails.

### FLOW of the Program:

`SampleTestClass.java` is the class where the test case is written and this class extends the `BaseTestClass.java` class inside which the driver is getting initiated and closed on test start and completion respectively.

A screenshot is taken whenever a test case fails inside the `SuiteListener.java` class and then the imgur POST request is hit using a JSON payload inside which the image is sent after being converted to Base64 String.

The URL from imgur is extracted from its response and the Slack incoming webhook is then hit using json payload inside which slack channel, pretext, username and the imgur image url parameters are getting passed.


### How To Run:
1. Right click on the testng.xml file and select 'Run testng.xml'
2. Open the testng.xml file and right click on it and select on 'Run testng.xml'


##### NOTE: 
1. Get the imgur authorization key by signing up on imgur website and add the key in `config.properties` file corresponding to key `authorization`
2. Go to your Slack app website and create an incoming webhook and add the url of the incoming webhook in `config.properties` file corresponding to key `slackBaseUri`


##### Sample Screenshot of the Message sent to Slack using this program:
![alt text](https://imgur.com/v1m7nkA.png)


##### Sample JSON Payload Body for Slack incoming webhook:
``````
{      
	"channel": "slackintegration",      
	"attachments": [{      
		"image_url": "https://imgur.com/v1m7nkA.png",   
	  	"username": "sameer",   
	    "pretext": "integrating slack"   
	}]   
}
```````

   
#### Important Links which can be referred:
[Slack Incoming Webhook Information](https://api.slack.com/messaging/webhooks)    
[Imgur Endpoints Information](https://api.imgur.com/endpoints/image/)
