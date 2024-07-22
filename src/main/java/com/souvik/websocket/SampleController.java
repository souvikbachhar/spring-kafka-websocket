package com.souvik.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
public class SampleController {

    @MessageMapping("/send")
    @SendTo("/topic/sample")
    public String sample(String message){
        return HtmlUtils.htmlEscape(message);
    }
}
