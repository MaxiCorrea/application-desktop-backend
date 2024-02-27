package com.github.maxicorrea.applicationdesktopbackend.application.usecases;

import com.github.maxicorrea.applicationdesktopbackend.application.ports.input.DisplayMenuInputPort;
import com.github.maxicorrea.applicationdesktopbackend.application.ports.output.LoadMenuOutputPort;
import com.github.maxicorrea.applicationdesktopbackend.common.UseCase;
import com.github.maxicorrea.applicationdesktopbackend.domain.Menu;

@UseCase
public class GetMenuUseCase implements DisplayMenuInputPort {

	private final LoadMenuOutputPort loadMenuOutputPort;

	public GetMenuUseCase(LoadMenuOutputPort loadMenuOutputPort) {
		this.loadMenuOutputPort = loadMenuOutputPort;
	}
	
	@Override
	public Menu display() {
		return loadMenuOutputPort.load();
	}

}
