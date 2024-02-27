package com.github.maxicorrea.applicationdesktopbackend.application.ports.input;

import com.github.maxicorrea.applicationdesktopbackend.domain.Feedback;

public interface SendFeedbackInputPort {
	void send(Feedback feedback);
}
