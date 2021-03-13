package com.github.jgzl.framework.config;

import com.github.alenfive.rocketapi.datasource.DataSourceDialect;
import com.github.alenfive.rocketapi.datasource.DataSourceManager;
import com.github.alenfive.rocketapi.datasource.MySQLDataSource;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * 默认数据源管理器
 */
@Component
@AllArgsConstructor
public class DefaultDataSourceManager extends DataSourceManager {

    private final JdbcTemplate jdbcTemplate;
    @PostConstruct
    public void init() {
        Map<String, DataSourceDialect> dialects = new HashMap<>();
        dialects.put("mysql", new MySQLDataSource(jdbcTemplate, true));
        super.setDialectMap(dialects);
    }
}
