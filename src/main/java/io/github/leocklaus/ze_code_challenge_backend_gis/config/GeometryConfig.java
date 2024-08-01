package io.github.leocklaus.ze_code_challenge_backend_gis.config;

import org.n52.jackson.datatype.jts.JtsModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeometryConfig {

    @Bean
    public JtsModule jtsModule(){
        return new JtsModule();
    }

}
