package com.webservices.scoretrack.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.util.Map;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ScoretrackResourceServerConfig extends ResourceServerConfigurerAdapter {

    static final String RESOURCE_ID = "scoretrack_resource";

    @Autowired
    CustomClientDetailsService customClientDetailsService;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID);
        // This is where you inject your custom error management
        //accessDeniedHandler(customAccessDeniedHandler()).authenticationEntryPoint(customAuthenticationEntryPoint())
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http
                .authorizeRequests()
                .antMatchers(("/api/games/talk")).permitAll()
                .antMatchers("/v1/account/**").hasAnyRole("USER", "SYSTEM_ADMIN", "GROUP_ADMIN")
                .antMatchers("v1/user/game").hasAnyRole("USER", "SYSTEM_ADMIN");
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore());
        tokenServices.setClientDetailsService(customClientDetailsService);
        return tokenServices;
    }


    @Bean
    @Primary
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }


    @Bean
    protected JwtAccessTokenConverter accessTokenConverter() {
        String jwtKeyStorePassword = "";
        String oauth2JwtKeyStoreKeyPairAlias = "";
        String oauth2JwtKeyStoreInternal = "eag-jwt-keystore.jks";

        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource(oauth2JwtKeyStoreInternal),
                jwtKeyStorePassword.toCharArray());

        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        // for asymmetric signing/verification
        converter.setKeyPair(keyStoreKeyFactory.getKeyPair(oauth2JwtKeyStoreKeyPairAlias));
        return converter;
    }


    /*@Bean
    public AuthenticationEntryPoint customAuthenticationEntryPoint() {
        final OAuth2AuthenticationEntryPoint entryPoint = new OAuth2AuthenticationEntryPoint();
        entryPoint.setExceptionTranslator(customExceptionTranslator());
        return entryPoint;
    }*/

    /*@Bean
    public WebResponseExceptionTranslator<Map> customExceptionTranslator() {
        return new CustomWebResponseExceptionTranslator();
    }*/
}
