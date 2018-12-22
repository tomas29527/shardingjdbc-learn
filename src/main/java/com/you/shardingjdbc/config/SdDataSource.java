package com.you.shardingjdbc.config;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * <一句话说明功能>
 * <功能详细描述>
 *
 * @author HX
 * @title <一句话说明功能>
 * @date 2018/12/21 16:08
 * @since <版本号>
 */

public class SdDataSource {

    @Autowired
    private DataSource datasource;

    private DataSource shardingDataSource;

    @PostConstruct
    public void init() throws SQLException {
        Map<String, DataSource> dataSourceMap = new HashMap<String, DataSource>();
        dataSourceMap.put("db1", datasource);

        // 配置Order表规则
//        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration();
//        orderTableRuleConfig.setLogicTable("user_info");
//        orderTableRuleConfig.setActualDataNodes("db${1}.user_info${0..1}");
//        // 配置分库 + 分表策略
//       // orderTableRuleConfig.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("u_id", "ds${id % 2}"));
//        orderTableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("u_id", "user_info${u_id % 2}"));
//        // 配置分片规则
//        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
//        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);
//        // 获取数据源对象
//        shardingDataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, new ConcurrentHashMap(), new Properties());

    }

    public DataSource getShardingDataSource() {
        return shardingDataSource;
    }
}
