package com.chipichipi.ProyectoOfipensiones.mongoconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.chipichipi.ProyectoOfipensiones.repositorios"},
        mongoTemplateRef = InstitucionConfig.MONGO_TEMPLATE
)
public class InstitucionConfig {

    protected static final String MONGO_TEMPLATE = "principalMongoTemplate";

}
