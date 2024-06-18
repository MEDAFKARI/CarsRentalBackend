package com.CarRental.CarRentalPFA.Utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.io.IOException;

@Configuration
public class RessourcesConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (isRunningInJar()) {
            registry.addResourceHandler("/content/**")
                    .addResourceLocations("classpath:/static/public/");
        } else {
            registry.addResourceHandler("/content/**")
                    //past  your absolute path dyal machine dylk
                    .addResourceLocations("file:///C:/Users/Med/Desktop/CarsRentalPFA/CarsRentalBackend/src/main/resources/static/public/");
        }
    }

    private boolean isRunningInJar() {
        try {

            Resource resource = new ClassPathResource("static/public/");
            File file = resource.getFile();
            return false;
        } catch (IOException e) {

            return true;
        }
    }
}
