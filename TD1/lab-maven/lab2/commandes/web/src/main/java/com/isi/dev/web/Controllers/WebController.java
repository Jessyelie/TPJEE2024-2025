package com.isi.dev.web.Controllers;

import com.isi.dev.services.CommandesServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "api")
public class WebController {
    private CommandesServices commandesServices;

    @GetMapping(name = "/commandes")
    public String index() {
        return commandesServices.getCommandes();
    }
}
