package com.ztj.springbootdemo;

import com.ztj.springbootdemo.properties.DBProperties;
import com.ztj.springbootdemo.properties.SitesProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class SpringbootdemoApplication {

    public static void main(String[] args) {
        /*
        start
         */
        System.out.println("--- application starts ---");
        ApplicationContext context = SpringApplication.run(SpringbootdemoApplication.class, args);

        /*
        new approaches in Spring Boot 2.0, helping us get properties
         */
        Binder binder = Binder.get(context.getEnvironment());
        DBProperties dbProperties = binder.bind("com.ztj.db", Bindable.of(DBProperties.class)).get();
        System.out.println(dbProperties.getLan());
        System.out.println(dbProperties.getDatabasePlatform());

        List<String> urlProperties = binder.bind("com.ztj.url", Bindable.listOf(String.class)).get();
        System.out.println(urlProperties);

        List<SitesProperties> sitesProperties = binder.bind("com.ztj.sites", Bindable.listOf(SitesProperties.class)).get();
        System.out.println(sitesProperties);

        System.out.println(context.getEnvironment().containsProperty("com.ztj.db.database-platform"));
    }

}
