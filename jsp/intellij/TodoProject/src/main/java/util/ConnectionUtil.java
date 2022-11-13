package util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtil {
    private HikariDataSource ds;

    private static ConnectionUtil instance = new ConnectionUtil();

    public static ConnectionUtil getInstance() {
        if(instance == null) {
            instance = new ConnectionUtil();
        }
        return instance;
    }

    private ConnectionUtil() {
        HikariConfig config = new HikariConfig();
        /*config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/project");
        config.setUsername("root");
        config.setPassword("admin");*/

        ConfigUtil conf = ConfigUtil.getInstance();
        config.setDriverClassName((String)conf.getConfig("jdbc"));
        config.setJdbcUrl((String)conf.getConfig("dbUrl"));
        config.setUsername((String)conf.getConfig("dbUser"));
        config.setPassword((String)conf.getConfig("dbPassword"));

        config.addDataSourceProperty("cachePrepStmts", true);
        config.addDataSourceProperty("prepStmtCacheSize", 250);
        config.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
        config.addDataSourceProperty("useServerPrepStmts", true);
        config.addDataSourceProperty("useLocalSessionState", true);
        config.addDataSourceProperty("rewriteBatchedStatements", true);
        config.addDataSourceProperty("cacheResultSetMetadata", true);
        config.addDataSourceProperty("cacheServerConfiguration", true);
        config.addDataSourceProperty("elideSetAutoCommits", true);
        config.addDataSourceProperty("maintainTimeStats", true);

        ds = new HikariDataSource(config);
    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
