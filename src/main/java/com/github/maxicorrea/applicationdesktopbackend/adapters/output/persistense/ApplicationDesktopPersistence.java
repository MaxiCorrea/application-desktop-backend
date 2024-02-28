package com.github.maxicorrea.applicationdesktopbackend.adapters.output.persistense;

import com.github.maxicorrea.applicationdesktopbackend.application.ports.output.LoadMenuOutputPort;
import com.github.maxicorrea.applicationdesktopbackend.application.ports.output.SaveFeedbackOutputPort;
import com.github.maxicorrea.applicationdesktopbackend.common.Persistence;
import com.github.maxicorrea.applicationdesktopbackend.domain.Feedback;
import com.github.maxicorrea.applicationdesktopbackend.domain.Menu;

@Persistence
public class ApplicationDesktopPersistence implements LoadMenuOutputPort, SaveFeedbackOutputPort {

  private final ApplicationDesktopRepository applicationDesktopRepository;

  public ApplicationDesktopPersistence(ApplicationDesktopRepository applicationDesktopRepository) {
    this.applicationDesktopRepository = applicationDesktopRepository;
  }

  @Override
  public void save(Feedback feedback) {
    applicationDesktopRepository.save(feedback);
  }

  @Override
  public Menu load() {
    return applicationDesktopRepository.load();
  }

}
