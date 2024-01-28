package com.gnpshop.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gnpshop.jwt.JwtConfig;
import com.gnpshop.jwt.JwtTokenVerifier;
import com.gnpshop.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import javax.crypto.SecretKey;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
//@RequiredArgsConstructor
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private final DataSource dataSource;
    private final ObjectMapper objectMapper;
    private final RestAuthenticationSuccessHandler successHandler;
    private final RestAuthenticationSuccessHandler failureHandler;
    private final PasswordEncoder passwordEncoder;

    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;

    public ApplicationSecurityConfig(
            DataSource dataSource,
            ObjectMapper objectMapper,
            RestAuthenticationSuccessHandler restAuthenticationSuccessHandler,
            RestAuthenticationSuccessHandler failureHandler,
            PasswordEncoder passwordEncoder,
            SecretKey secretKey,
            JwtConfig jwtConfig) {
        this.dataSource = dataSource;
        this.objectMapper = objectMapper;
        successHandler = restAuthenticationSuccessHandler;
        this.failureHandler = failureHandler;
        this.passwordEncoder = passwordEncoder;
        this.secretKey = secretKey;
        this.jwtConfig = jwtConfig;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .withDefaultSchema()
                .dataSource(dataSource)
                .withUser("test")
                .password("{bcrypt}" + new BCryptPasswordEncoder().encode("test"))
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig, secretKey))
                .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig), JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
//                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
    }

//    public JsonObjectAuthenticationFilter authenticationFilter() throws Exception {
//        JsonObjectAuthenticationFilter authenticationFilter = new JsonObjectAuthenticationFilter(objectMapper);
//        authenticationFilter.setAuthenticationSuccessHandler(successHandler);
//        authenticationFilter.setAuthenticationFailureHandler(failureHandler);
//        authenticationFilter.setAuthenticationManager(super.authenticationManager());
//        return authenticationFilter;
//    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("password"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("password"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }
}
