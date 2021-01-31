package lt.edas.demo.poc.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class AppController implements AppMapping {

    private final Logger logger;

    @Override
    public void ping(HttpServletRequest request) {
        logger.info("Connected from {}", request.getRemoteAddr());
    }

    @Override
    public void createPerson() {

    }

    @Override
    public void getPerson() {

    }

    @Override
    public void updatePerson() {

    }
}
