# springboot-oauth2

[Documentation]
https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-security.html

Step 1:) Authorise application using below login and obtain auth_code For eg :- 7yX67P
It will redirect to login page and from network logs get the code form query param
http://localhost:8080/auth/oauth/authorize?response_type=code&client_id=acme&redirect_uri=http://google.com


Step: 2) Below Url POST with auth_code
http://localhost:8080/auth/oauth/token?client_id=acme&client_secret=acmesecret&grant_type=authorization_code&code=EigB9k&redirect_uri=http://google.com 
To get Below info
{"access_token":"d33bf962-0312-462a-ac64-1691af92cc41","token_type":"bearer","refresh_token":"737025d1-ab96-4ac2-aa1c-d7f66efbdf2a","expires_in":5999,"scope":"read testApproval write"}


Step :3)Call secured service with the below header and replace header with token we got in previous step

Authorization Bearer d33bf962-0312-462a-ac64-1691af92cc41
