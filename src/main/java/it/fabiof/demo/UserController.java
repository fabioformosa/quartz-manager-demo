package it.fabiof.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/quartz-manager/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @GetMapping("/whoami")
    public @ResponseBody String user() {
        return "\"NO_AUTH\"";
    }

}
