package pl.oskarpolak.fivartoserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.oskarpolak.fivartoserver.configs.WebSocketConfig;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by Lenovo on 12.06.2017.
 */
@Controller
public class SocketController {

    @MessageMapping("/hello")
    @SendTo("/answer")
    public String greeting(String message) throws Exception {
        System.out.println("Dostałem wiadomość! " + message);
        return "Odp od serwera: SIEMA";
    }

    @Autowired
    WebSocketConfig config;

    @RequestMapping("/")
    public void hehe() {
       // stringcos;
    }




}


