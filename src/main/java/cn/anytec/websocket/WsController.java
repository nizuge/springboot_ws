package cn.anytec.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WsController {

    private static final Logger logger = LoggerFactory.getLogger(WsController.class);

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/123/registry0")
    @SendTo("/topic/greet123")
    public String hello(@Header("testH")String test, String helage){
        logger.info("/registry0");
        return "reply:"+helage+" "+test;
    }

    @MessageMapping("/{hehe}/hello/registry1")
    public String send(String message, @DestinationVariable(value="hehe") String hehe) {

        System.out.println("message=="+message);
        System.out.println("hehe=="+hehe);
        return "";
    }
   /* @MessageMapping("/registry1")
    @SendTo("/topic/greetings")
    public String hello3(@Header("testH")String test, String helloMessage){
        logger.info("/registry1");
        logger.info(test);
        return "reply:"+helloMessage;
    }*/
}
