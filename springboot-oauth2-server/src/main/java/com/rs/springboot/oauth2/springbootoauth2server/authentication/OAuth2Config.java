package com.rs.springboot.oauth2.springbootoauth2server.authentication;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
	
	/*@Autowired
    private AuthenticationManager authenticationManager;
    
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
      endpoints.authenticationManager(authenticationManager);
    }*/

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception
	{
	   oauthServer.checkTokenAccess("permitAll()");    
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients)
			throws Exception {
		System.out.println("COMING HERE");
		 clients.inMemory()
         .withClient("acme")
         .secret("acmesecret")
         .authorizedGrantTypes("authorization_code","refresh_token")//, "authorization_code", "refresh_token")
         .scopes("read", "write", "testApproval")
         .accessTokenValiditySeconds(6000);
	}

}
