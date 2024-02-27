package com.github.maxicorrea.applicationdesktopbackend.application.usecases;

import com.github.maxicorrea.applicationdesktopbackend.application.ports.input.SendFeedbackInputPort;
import com.github.maxicorrea.applicationdesktopbackend.application.ports.output.SaveFeedbackOutputPort;
import com.github.maxicorrea.applicationdesktopbackend.common.UseCase;
import com.github.maxicorrea.applicationdesktopbackend.domain.Feedback;

@UseCase
public class SendFeedbackUseCase implements SendFeedbackInputPort {

	private final SaveFeedbackOutputPort feedbackOutputPort;
	
	public SendFeedbackUseCase(SaveFeedbackOutputPort feedbackOutputPort) {
		this.feedbackOutputPort = feedbackOutputPort;
	}
	
	@Override
	public void send(Feedback feedback) {
		feedbackOutputPort.save(feedback);
	}

}
