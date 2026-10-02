package com.kamaleshwaran.portfolio.data;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

@Component
public class ProfilePhotoColumnMigration implements ApplicationRunner {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public ProfilePhotoColumnMigration(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(ApplicationArguments args) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metadata = connection.getMetaData();
            if (!metadata.getDatabaseProductName().toLowerCase(Locale.ROOT).contains("mysql")) {
                return;
            }

            try (ResultSet columns = metadata.getColumns(
                    connection.getCatalog(), null, "developer_profiles", "photo_url")) {
                if (!columns.next() || "LONGTEXT".equalsIgnoreCase(columns.getString("TYPE_NAME"))) {
                    return;
                }
            }
        }

        jdbcTemplate.execute("ALTER TABLE developer_profiles MODIFY COLUMN photo_url LONGTEXT");
    }
}