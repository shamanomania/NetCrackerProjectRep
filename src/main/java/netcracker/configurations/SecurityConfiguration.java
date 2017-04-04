package netcracker.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sid775 on 08.03.2017.
 */
@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
@RestController
@RequestMapping("/main")
@Configurable
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@EnableOAuth2Sso
class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    OAuth2ClientContext oauth2ClientContext;

    @Autowired
    AuthorizationCodeResourceDetails authorizationCodeResourceDetails;

    @Autowired
    ResourceServerProperties resourceServerProperties;

    @Autowired
    private UserDetailsService userDetailsService;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

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
                // starts authorizing configurations
                .authorizeRequests()
                .antMatchers("/", "/home","/**.html", "/**.js","/fbInt").permitAll()
                .antMatchers("/goInt").permitAll()
                // authenticate all remaining URLS
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").usernameParameter("email")
                .successForwardUrl("/")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                // setting the logout URL "/logout" - default logout URL
                .logout()//
                // after successful logout the application will redirect to "/"
                // path
                .logoutSuccessUrl("/")//
                .permitAll()//
                .and()//
                // Setting the filter for the URL "/google/login"
                .addFilterAt(filter(), BasicAuthenticationFilter.class)//
                .csrf()//
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());


      //  http.csrf().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());*/
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
    }


    // This method is for overriding some configuration of the WebSecurity
    // If you want to ignore some request or request patterns then you can
    // specify that inside this method
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    /**
     * Method for creating filter for OAuth authentication
     *
     * @return OAuth2ClientAuthenticationProcessingFilter
     */
    private OAuth2ClientAuthenticationProcessingFilter filter() {
        // Creating the filter for "/google/login" url
        OAuth2ClientAuthenticationProcessingFilter oAuth2Filter = new OAuth2ClientAuthenticationProcessingFilter(
                "/google/login");


        // Creating the rest template for getting connected with OAuth service.
        // The configuration parameters will inject while creating the bean.
        OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(authorizationCodeResourceDetails,
                oauth2ClientContext);
        oAuth2Filter.setRestTemplate(oAuth2RestTemplate);


        // setting the token service. It will help for getting the token and
        // user details from the OAuth Service
        oAuth2Filter.setTokenServices(new UserInfoTokenServices(resourceServerProperties.getUserInfoUri(),
                resourceServerProperties.getClientId()));


        return oAuth2Filter;
    }
}
