package com.github.maxicorrea.applicationdesktopbackend.adapters.output.persistense;

import com.github.maxicorrea.applicationdesktopbackend.domain.Feedback;
import com.github.maxicorrea.applicationdesktopbackend.domain.Menu;

public interface ApplicationDesktopRepository {

  void save(Feedback feedback);

  Menu load();

}
