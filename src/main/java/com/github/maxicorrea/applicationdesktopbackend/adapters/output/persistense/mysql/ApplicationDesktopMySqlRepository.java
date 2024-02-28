package com.github.maxicorrea.applicationdesktopbackend.adapters.output.persistense.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.github.maxicorrea.applicationdesktopbackend.adapters.output.persistense.ApplicationDesktopRepository;
import com.github.maxicorrea.applicationdesktopbackend.common.Persistence;
import com.github.maxicorrea.applicationdesktopbackend.domain.App;
import com.github.maxicorrea.applicationdesktopbackend.domain.Feedback;
import com.github.maxicorrea.applicationdesktopbackend.domain.Menu;
import com.zaxxer.hikari.HikariDataSource;

@Persistence
@Profile("dev")
public class ApplicationDesktopMySqlRepository implements ApplicationDesktopRepository {

  @Autowired
  private HikariDataSource dataSource;
  
  @Override
  public Menu load() {
    StringBuilder queryBuilder = new StringBuilder();
    queryBuilder.append("SELECT * FROM App");
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
    String query = queryBuilder.toString();
    List<App> apps = jdbcTemplate.query(query, new AppRowMapper());
    Menu menu = new Menu();
    menu.setApps(apps);
    return menu;
  }

  private class AppRowMapper implements RowMapper<App> {
    @Override
    public App mapRow(ResultSet rs, int rowNum) throws SQLException {
      App obj = new App();
      obj.setId(rs.getInt("id"));
      obj.setName(rs.getString("name"));
      obj.setDescription(rs.getString("description"));
      obj.setUrl(rs.getString("url"));
      obj.setBase64(rs.getString("base64"));
      return obj;
    }    
  }
  
  @Override
  public void save(Feedback feedback) {
    
  }
  
}
