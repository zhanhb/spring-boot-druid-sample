/*
 * Copyright 2015 zhanhb.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.zhanhb.customdatasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author zhanhb
 */
@Configuration
public class CustomDataSource {

    @Autowired
    private DataSourceProperties properties;

    @Bean
    @ConfigurationProperties(prefix = DataSourceProperties.PREFIX) // this will inject other properties to the datasource
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .type(DruidDataSource.class)
                .url(properties.getUrl())
                .username(properties.getUsername())
                .password(properties.getPassword())
                .build();
    }

    //public DataSource dataSource() {
    //    DruidDataSource dataSource = new DruidDataSource();
    //    dataSource.setUrl("...");
    //    dataSource.setUsername("...");
    //    dataSource.setPassword("...");
    //    return dataSource;
    //}
}
