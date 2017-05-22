package netcracker.configurations;

import netcracker.filters.GoogleOAuth2Filter;
import netcracker.filters.GoogleOauth2AuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

import javax.annotation.Resource;

/**
 * Created by Sid775 on 08.03.2017.
 */

@Configuration
@EnableGlobalAuthentication
@EnableOAuth2Client
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@PropertySource(value = {"classpath:oauth.properties"})
class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Resource
    @Qualifier("accessTokenRequest")
    private AccessTokenRequest accessTokenRequest;

    @Autowired
    private OAuth2ClientContextFilter oAuth2ClientContextFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http.authorizeRequests()
                .antMatchers("/", "/public*//**").permitAll()
                .antMatchers("/ide").permitAll()
                .antMatchers("/users*//**").hasAuthority("ADMIN")
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .usernameParameter("email")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .deleteCookies("remember-me")
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
                .rememberMe();*/


        http
                .headers()
                // allow iframe
                 .addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
                .and()
                .authorizeRequests()
               // .antMatchers("/", "/home","/protected","/signup").permitAll()
                .antMatchers("/", "/home","/signin/**","/signup/**","/login**","/google_oauth2_login","/vk/signin**","/vk/callback**","/facebook/signin**","/facebook/callback**","/hh/signin**","/hh/callback**").permitAll()
                .antMatchers("/ide").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                  .loginPage("/login").usernameParameter("email")
                  .defaultSuccessUrl("/user")
                  .permitAll()
                .and()
                .logout()
                    .permitAll()
                    .logoutSuccessUrl("/")
                .and()
                .addFilterAfter(oAuth2ClientContextFilter,ExceptionTranslationFilter.class)
                .addFilterAfter(googleOAuth2Filter(),OAuth2ClientContextFilter.class)
                .userDetailsService(userDetailsService);
        http.csrf().disable();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @ConfigurationProperties("google.client")
    public OAuth2ProtectedResourceDetails auth2ProtectedResourceDetails() {
        return new AuthorizationCodeResourceDetails();
    }

    @Bean
    public OAuth2RestTemplate oauth2RestTemplate() {
        return new OAuth2RestTemplate(auth2ProtectedResourceDetails(),
                new DefaultOAuth2ClientContext(accessTokenRequest));
    }

    @Bean
    public GoogleOAuth2Filter googleOAuth2Filter() {
        return new GoogleOAuth2Filter("/google_oauth2_login");
    }

    /*
    *  Building our custom Google Provider
    * */
    @Bean
    public GoogleOauth2AuthProvider googleOauth2AuthProvider() {
        return new GoogleOauth2AuthProvider();
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder())
                .and()
                .authenticationProvider(googleOauth2AuthProvider());
                // auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
    }

    @Bean
        public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }
}
