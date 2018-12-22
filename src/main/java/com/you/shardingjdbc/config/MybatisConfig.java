package com.you.shardingjdbc.config;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * MyBatis配置
 * 配置mapper扫描和分页插件，开启spring事务管理
 *
 * @author follow
 * @title MyBatis配置
 * @date 2018/4/15
 * @since 1.0.0
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.you.shardingjdbc.dao.mapper")
public class MybatisConfig implements TransactionManagementConfigurer {

   @Autowired
   private DataSource dataSource;

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.you.shardingjdbc.entity.dao");

        //分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "false");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        bean.setPlugins(new Interceptor[]{pageHelper});

        try {
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            // mybatis配置
            org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
            configuration.setLazyLoadingEnabled(true);
            configuration.setUseGeneratedKeys(true);
            configuration.setDefaultExecutorType(ExecutorType.REUSE);
            configuration.setDefaultStatementTimeout(30);
            configuration.setMapUnderscoreToCamelCase(true);
            configuration.setAutoMappingBehavior(AutoMappingBehavior.FULL);
            bean.setConfiguration(configuration);

            bean.setMapperLocations(resolver.getResources("classpath*:mapper/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
