package com.example.Server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Контроллер, управляет записями в БД
 * отвечает на запросы клиентов
 */
@RestController
public class ServerController {
    /**
     * Общий запрос, наберите в браузере http://localhost:8080/
     * вместо localhost - IP адрес сервера
     * @return "База данных поликлиники"
     */
    @GetMapping("/")
    private String getInfo() {
        return "База данных поликлиники";
    }
}
