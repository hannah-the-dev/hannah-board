package com.hannah.hannahboard.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DataSourceCheck {

    public DataSourceCheck(
            @Value("${spring.datasource.url}") String url) {

        System.out.println("DATASOURCE URL = " + url);
    }
}