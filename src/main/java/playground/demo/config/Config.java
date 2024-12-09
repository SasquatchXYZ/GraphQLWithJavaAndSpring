package playground.demo.config;

import graphql.schema.TypeResolver;
import graphql.schema.idl.TypeRuntimeWiring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class Config {
    TypeResolver petTypeResolver = (env -> {
        // Your custom type resolver logic here...
        return null;
    });

    @Bean
    RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> {
            TypeRuntimeWiring petWiring = TypeRuntimeWiring.newTypeWiring("Pet")
                    .typeResolver(petTypeResolver)
                    .build();

            wiringBuilder.type(petWiring);
        };
    }
}
