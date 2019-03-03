package com.example.gits.ctx;

import com.example.gits.spm.GitsApplication;
import com.example.gits.spm.GitsApplicationBuilder;
import com.speedment.runtime.core.ApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GitsDbms {
    @Bean
    public GitsApplication gitsApplication(){
        GitsApplication app = new GitsApplicationBuilder().withPassword("root")
                .withParam("db.mysql.collationName", "utf8mb4_general_ci")
                .withParam("db.mysql.binaryCollationName", "utf8mb4_bin")
                .withLogging(ApplicationBuilder.LogType.APPLICATION_BUILDER)
                .withLogging(ApplicationBuilder.LogType.STREAM)
                .withLogging(ApplicationBuilder.LogType.STREAM_OPTIMIZER)
                .withLogging(ApplicationBuilder.LogType.PERSIST)
                .withLogging(ApplicationBuilder.LogType.UPDATE)
                .withLogging(ApplicationBuilder.LogType.REMOVE)
                .withLogging(ApplicationBuilder.LogType.CONNECTION)
                .withLogging(ApplicationBuilder.LogType.TRANSACTION)
                .withLogging(ApplicationBuilder.LogType.JOIN)
                .build();
          return app;
    }
}
