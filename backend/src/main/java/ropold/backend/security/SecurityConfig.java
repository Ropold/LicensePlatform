package ropold.backend.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import ropold.backend.model.user.UserModel;
import ropold.backend.repository.UserRepository;
import ropold.backend.service.IdService;

import java.time.LocalDateTime;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Value("${app.url}")
    private String appUrl;

    private final UserRepository userRepository;
    private final IdService idService;
    private static final String CUSTOMER = "/api/customers/**";
    private static final String USER = "/api/users/**";
    private static final String MANUFACTURER = "/api/manufacturers/**";
    private static final String LICENSE = "/api/licenses/**";
    private static final String INVOICE = "/api/invoices/**";


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(a -> a
//                        .requestMatchers(HttpMethod.POST, "/api/customers/no-login").permitAll()
                        .requestMatchers(HttpMethod.GET, CUSTOMER,USER,MANUFACTURER,LICENSE,INVOICE).permitAll()
                        .requestMatchers(HttpMethod.POST, CUSTOMER,USER,MANUFACTURER,LICENSE,INVOICE).authenticated()
                        .requestMatchers(HttpMethod.PUT, CUSTOMER,USER,MANUFACTURER,LICENSE,INVOICE).authenticated()
                        .requestMatchers(HttpMethod.DELETE, CUSTOMER,USER,MANUFACTURER,LICENSE,INVOICE).authenticated()
//                        .requestMatchers("/api/users/me").permitAll()
//                        .requestMatchers("/api/users/me/details").permitAll()
                )
                .logout(l -> l.logoutUrl("/api/users/logout")
                        .logoutSuccessHandler((request, response, authentication) -> response.setStatus(200)))
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .exceptionHandling(e -> e
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                .oauth2Login(o -> o.defaultSuccessUrl(appUrl));

        return http.build();
    }

    @Bean
    public OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService() {
        DefaultOAuth2UserService userService = new DefaultOAuth2UserService();

        return (userRequest) -> {
            OAuth2User githubUser = userService.loadUser(userRequest);

            String githubId = githubUser.getName();
            String username = githubUser.getAttribute("login");
//            String name = githubUser.getAttribute("name");
            String avatarUrl = githubUser.getAttribute("avatar_url");

            UserModel user = userRepository.findByMicrosoftId(githubId)
                    .orElseGet(() -> {
                        UserModel newUser = new UserModel();
                        newUser.setMicrosoftId(githubId);
                        newUser.setUsername(username);
                        newUser.setAvatarUrl(avatarUrl);
                        newUser.setRole("ROLE_USER");
                        newUser.setCreatedAt(LocalDateTime.now());
                        return userRepository.save(newUser);
                    });
            return githubUser;
        };
    }

}
