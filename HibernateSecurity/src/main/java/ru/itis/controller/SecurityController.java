package ru.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itis.models.User;
import ru.itis.models.Token;
import ru.itis.services.SecurityService;

import java.util.List;

@Controller
public class FilmsController {

    @Autowired
    private SecurityService securityService;

}
