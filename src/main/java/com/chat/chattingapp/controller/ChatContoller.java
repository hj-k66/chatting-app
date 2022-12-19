package com.chat.chattingapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatContoller {

    @PostMapping("/message")
    public String writeMessage(){
        return "메세지가 작성되었습니다.";
    }
}
