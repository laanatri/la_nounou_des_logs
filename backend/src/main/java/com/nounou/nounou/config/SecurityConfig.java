@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/api/health").permitAll()
                .anyRequest().authenticated()
            )
                .formLogin().disable()
                .httpBasic(basic -> {});
        return http.build();
    }

}