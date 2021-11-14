package ljh.commerce.commerce.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
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
        http.authorizeRequests()
                .antMatchers("/", "/shop/**", "/signup","/css/**","/js/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/signin").permitAll()
                .loginProcessingUrl("/signin").defaultSuccessUrl("/");
//                .antMatchers("/","/shop/**","/signup",).permitAll()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and().formLogin().loginPage("/signin").permitAll()
//                .failureUrl("/signin?error=true")
//                .loginProcessingUrl("/signin")
//                .defaultSuccessUrl("/home")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .and()
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/signin").invalidateHttpSession(true);
    }
}
