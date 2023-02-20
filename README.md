Mail sender for Gmail

Important: Use this program as an alternative if Gmail admin access is not available to allow multi send feature.

Please follow this link to setup the App password for Gmail and replace in line 20 and 21 of SendMail.java:
````
final String username = "";
final String password = "";
````

https://support.google.com/accounts/answer/185833?p=InvalidSecondFactor

Code taken from:

https://mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/

TODO:
- Create a text file for list of recipients
- Loop through the file and send email to everyone
