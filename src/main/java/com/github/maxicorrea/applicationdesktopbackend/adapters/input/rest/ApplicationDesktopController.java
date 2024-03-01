package com.github.maxicorrea.applicationdesktopbackend.adapters.input.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.maxicorrea.applicationdesktopbackend.application.ports.input.DisplayMenuInputPort;
import com.github.maxicorrea.applicationdesktopbackend.common.Rest;
import com.github.maxicorrea.applicationdesktopbackend.domain.Menu;
import io.swagger.v3.oas.annotations.tags.Tag;

@Rest
@RestController
@Tag(name = "Application menu")
public class ApplicationDesktopController {

  private final DisplayMenuInputPort displayMenuInputPort;

  public ApplicationDesktopController(DisplayMenuInputPort displayMenuInputPort) {
    this.displayMenuInputPort = displayMenuInputPort;
  }

  @GetMapping("/")
  public Menu getMenu() {
    return displayMenuInputPort.display();
  }

}
