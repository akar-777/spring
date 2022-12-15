package ir.assignment.football.config;

import javax.sql.DataSource;

import ir.assignment.football.repository.MatchRepo;
import ir.assignment.football.repository.TeamRepo;
import ir.assignment.football.repository.impl.MatchRepoImpl;
import ir.assignment.football.repository.impl.TeamRepoImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "ir.assignment.football")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
//		dataSource.setDriverClassName("org.hibernate.dialect.MySQL5InnoDBDialect");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        dataSource.setUrl("jdbc:mysql://localhost:3306/football");
        dataSource.setUsername("root");
        dataSource.setPassword("mysql_1364");
        dataSource.setConnectionProperties(null);

        return dataSource;
    }

    @Bean
    public TeamRepo getTeamDAO() {
        return new TeamRepoImpl(getDataSource());
    }

    @Bean
    public MatchRepo getPredictionDAO() {
        return new MatchRepoImpl(getDataSource());
    }
}
