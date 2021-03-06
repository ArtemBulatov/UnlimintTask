package ru.bulatov.unlimintTask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.bulatov.unlimintTask.FilesParser;
import ru.bulatov.unlimintTask.typesOfParse.CsvParser;
import ru.bulatov.unlimintTask.typesOfParse.JsonParser;

@Configuration
public class SpringConfig {

    @Bean
    @Scope("prototype")
    public CsvParser csvParser() {
        return new CsvParser();
    }

    @Bean
    @Scope("prototype")
    public JsonParser jsonParser(){
        return new JsonParser();
    }

    @Bean
    @Scope("prototype")
    public FilesParser filesParser(){
        return new FilesParser(csvParser(), jsonParser());
    }

}
