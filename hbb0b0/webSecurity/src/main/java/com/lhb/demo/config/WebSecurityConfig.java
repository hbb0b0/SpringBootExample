package com.lhb.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //取消对 授权检查/,/home
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()

                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        /*
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
                */
        //新版本的Spring Security要求必须为用户配置提供编码器，否则会报找不到相应的编码器错误。这里有个不是很重要的知识点，
        // 假如我们没有调用passwordEncoder方法为用户验证指明编码器，那么有一种替代方案，就是在密码前加"{noop}"等前缀，
        // 跟踪源码发现，框架会自动解析{}中的key去匹配相应的编码器。下面提供一个调试的图，可以了解下。
        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("lhb").password("123").roles("USER").and()
                .withUser("admin").password("admin").roles("USER","ADMIN");
    }

}
