package ru.Dzhanaev.SpringFWStarter.lessons.mvc.lesson16;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

import javax.sql.DataSource;

/**
 * @author Artur Dzhanaev
 * @created 04.01.2023
 */
@Slf4j
@ComponentScan("ru.Dzhanaev.SpringFWStarter.lessons.mvc")
@Configuration
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {


    private final ApplicationContext applicationContext;


    @Contract(pure = true)
    public SpringConfig(@Autowired ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean(name = "springResourceTemplateResolver16")
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver springResourceTemplateResolver = new SpringResourceTemplateResolver();
        springResourceTemplateResolver.setApplicationContext(applicationContext);
        springResourceTemplateResolver.setPrefix("classpath:templates/");
        springResourceTemplateResolver.setSuffix(".html");
        return springResourceTemplateResolver;
    }

    @Bean(name = "springTemplateEngine16")
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(templateResolver());
        springTemplateEngine.setEnableSpringELCompiler(true);
        return springTemplateEngine;
    }

    @Override
    public void configureViewResolvers(@NotNull ViewResolverRegistry registry) {
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(templateEngine());
        registry.viewResolver(thymeleafViewResolver);
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/first_db");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("blockPost");
        return driverManagerDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
