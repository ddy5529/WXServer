/*
package com.ddy.wxServer.Configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.ddy.wxServer", sqlSessionTemplateRef  = "mybatisMasterSqlSessionTemplate")
public class MybatisMasterDataSourceConfig {
    @Bean(name = "mybatisMasterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource mybatisMasterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mybatisMasterSqlSessionFactory")
    public SqlSessionFactory mybatisMasterSqlSessionFactory(@Qualifier("mybatisMasterDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mybatis/mapper/master/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "mybatisMasterTransactionManager")
    public DataSourceTransactionManager mybatisMasterTransactionManager(@Qualifier("mybatisMasterDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "mybatisMasterSqlSessionTemplate")
    public SqlSessionTemplate mybatisMasterSqlSessionTemplate(@Qualifier("mybatisMasterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
*/
