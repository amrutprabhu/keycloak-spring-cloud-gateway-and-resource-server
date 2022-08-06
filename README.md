# Spring Cloud Gateway with Keycloak Integration using OAuth2 OpenId Connect (OIDC)
<a href="https://foojay.io/works-with-openjdk"><img align="right" src="https://github.com/foojayio/badges/raw/main/works_with_openjdk/Works-with-OpenJDK.png" width="100"></a>


In this project I am integrating Keycloak with spring cloud gateway as a client using Oauth2 OpenId Connect (OIDC).

We create a realm in keycloak containing a client and set of users. We then integrate the client configuration in our spring cloud gateway application and then authenticate using OpenId Connect.

You can read about this in detail on how to integrate Keycloak with Spring Cloud Gateway on my website [RefactorFirst.com](https://refactorfirst.com)

## Details Useful for debugging OAuth2 flow

1. To debug issues, you can set the logging to debug using these settings
```properties
logging:
    level:
      org:
        springframework:
          security: DEBUG
```

2. You can find the list of common OAuth2 providers like Okta, Google, etc in this class.
   ```java
   org.springframework.security.config.oauth2.client.CommonOAuth2Provider
   ```
3. You can find the start of the configuration from this class for all client registrations. 
```java
org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientPropertiesRegistrationAdapter#getClientRegistrations
```
4. Your OAuth2 client properties are found in this class
```java
org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties
```
5. The place where it stores incoming resource request to serve once the authentication is successful is in this class

```java
org.springframework.security.web.server.savedrequest.WebSessionServerRequestCache.saveRequest
```

Export Keyclock Config.

```shell
docker exec -it 22dadc3be0dd  /opt/keycloak/bin/kc.sh export --dir /tmp/ --users realm_file --realm My-Realm
```
Clients can trigger login with url : 

```
oauth2/authorization/keycloak-spring-gateway-client
```