package fiap.com.br.globalsolution.config;

import fiap.com.br.globalsolution.repository.OngRepository;
import fiap.com.br.globalsolution.security.AuthorizationFilter;
import fiap.com.br.globalsolution.service.AuthenticationService;
import fiap.com.br.globalsolution.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@Order(1)
public class SecurityConfigurationApi extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService authenticationService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private OngRepository repository;

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationService)
                .passwordEncoder(AuthenticationService.getPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/api/**")
                .authorizeRequests()
                    .antMatchers("/api/auth")
                        .permitAll()
                    .anyRequest()
                        .authenticated()
                    .and()
                        .csrf()
                        .disable()
                    .sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                        .addFilterBefore(new AuthorizationFilter(tokenService, repository), UsernamePasswordAuthenticationFilter.class)
        ;
    }

}