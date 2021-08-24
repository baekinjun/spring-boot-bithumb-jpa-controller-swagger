package net.injun.api.security.config;

import lombok.RequiredArgsConstructor;
import net.injun.api.security.aop.SecurityFilter;
import net.injun.api.security.domain.SecurityProvider;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//security config 첫번쨰로 설정을 해야한다.! 그러면서 반드시 필요한 객체를 표시 한다! 그순서에 따라 개발툴이 자동으로 작성하도록 하는것이 좋다!
@RequiredArgsConstructor
public class SecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final SecurityProvider provider;

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        SecurityFilter filter = new SecurityFilter(provider);
        builder.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }
}
