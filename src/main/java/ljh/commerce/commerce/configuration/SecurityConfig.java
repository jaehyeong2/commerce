package ljh.commerce.commerce.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder encode() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().
                antMatchers("/","/signup","/signin","/shop/**","/api/**").permitAll()
                .antMatchers("/user/**").authenticated()
                .antMatchers("/admin/**").authenticated()
                //.hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/signin")
                .loginProcessingUrl("/signin")
                .defaultSuccessUrl("/");
    }
}
