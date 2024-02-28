package com.github.maxicorrea.applicationdesktopbackend.adapters.output.persistense.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import com.github.maxicorrea.applicationdesktopbackend.adapters.output.persistense.ApplicationDesktopRepository;
import com.github.maxicorrea.applicationdesktopbackend.common.Persistence;
import com.github.maxicorrea.applicationdesktopbackend.domain.App;
import com.github.maxicorrea.applicationdesktopbackend.domain.Feedback;
import com.github.maxicorrea.applicationdesktopbackend.domain.Menu;

@Persistence
@Profile("prod")
public class ApplicationDesktopFileRepository implements ApplicationDesktopRepository {

  private Logger logger = LoggerFactory.getLogger(ApplicationDesktopFileRepository.class);

  @Override
  public Menu load() {
    try (InputStream stream = getClass().getResourceAsStream("/file/App.txt");
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader buffer = new BufferedReader(reader)) {
   
      List<String> lines = new ArrayList<>();
      List<App> apps = new ArrayList<>();
      String line;
      while ((line = buffer.readLine()) != null) {
        if(line.trim().isEmpty()) {
          apps.add(createAppOf(lines));
          lines.clear();
        } else {
          lines.add(line);
        }
      }
      Menu menu = new Menu();
      menu.setApps(apps);
      logger.info("Returned {} Apps", menu.getApps().size());
      return menu;
    } catch (FileNotFoundException e) {
      logger.error("File not Found");
    } catch (IOException e) {
      logger.error("Read File error");
    }
    return null;
  }

  private App createAppOf(
      final List<String> lines) {
    App obj = new App();
    int idx = 0;
    obj.setId(Integer.valueOf(lines.get(idx++).replaceFirst("id:", "")));
    obj.setName(lines.get(idx++).replaceFirst("name:", ""));
    obj.setDescription(lines.get(idx++).replaceFirst("description:", ""));
    obj.setUrl(lines.get(idx++).replaceFirst("url:", ""));
    obj.setBase64(lines.get(idx++).replaceFirst("base64:", ""));
    return obj;
  }
  
  @Override
  public void save(Feedback feedback) {

  }

}
