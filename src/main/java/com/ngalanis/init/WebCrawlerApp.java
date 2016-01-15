package com.ngalanis.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.ngalanis")
public class WebCrawlerApp {

    private static final Logger log = LoggerFactory.getLogger(WebCrawlerApp.class);

    public static void main(String[] args) {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(WebCrawlerConfig.class);

        WebCrawlerApp marfeelizable = ctx.getBean(WebCrawlerApp.class);
	}

}

