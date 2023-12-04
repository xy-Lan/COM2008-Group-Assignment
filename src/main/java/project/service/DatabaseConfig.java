//package project.service;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//
//import javax.sql.DataSource;
//
//import static project.service.MySqlService.dataSource;
//
//public class DatabaseConfig {
//    private static HikariDataSource dataSource;
//
//    public static DataSource getDataSource() {
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl("jdbc:mysql://stusql.dcs.shef.ac.uk/team015");
//        config.setUsername("team015");
//        config.setPassword("eSh7Shahk");
//        config.addDataSourceProperty("cachePrepStmts", "true");
//        config.addDataSourceProperty("prepStmtCacheSize", "250");
//        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
//        config.setMaximumPoolSize(50);
//
//        return new HikariDataSource(config);
//    }
//
//    public static HikariDataSource getHikariDataSource() {
//        if (dataSource == null) {
//            getDataSource();
//        }
//        return dataSource;
//    }
//}
