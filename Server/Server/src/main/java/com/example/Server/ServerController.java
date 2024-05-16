package com.example.Server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Контроллер, управляет записями в БД
 * отвечает на запросы клиентов
 */
@RestController
public class ServerController {
    @GetMapping("/")
    private String getInfo() {
        return "База данных поликлиники";
    }
}
