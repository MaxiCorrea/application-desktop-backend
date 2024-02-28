package com.github.maxicorrea.applicationdesktopbackend.application.ports.output;

import com.github.maxicorrea.applicationdesktopbackend.domain.Feedback;

public interface SaveFeedbackOutputPort {
  void save(Feedback feedback);
}
