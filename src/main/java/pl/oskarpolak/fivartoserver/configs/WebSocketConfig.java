package pl.oskarpolak.fivartoserver.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.*;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Base64;

@Configuration
@EnableWebSocket
public class WebSocketConfig extends BinaryWebSocketHandler implements WebSocketConfigurer {




    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(this, "/myHandler").setAllowedOrigins("*");
    }

    File file = new File("C:\\Drivers\\oskar.png");

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);

        System.out.println("Paczka danych:  " + message.getPayloadLength());
        for (int i = 0; i <   message.getPayload().limit(); i++)
        {
            fileOutputStream.write(message.getPayload().get());
        }

        System.out.println("SessionID: " + session.getId());

        fileOutputStream.close();
        message.getPayload().clear();



    }



    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println(session.getId());
    }
}