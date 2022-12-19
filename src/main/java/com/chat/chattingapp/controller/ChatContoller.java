package com.chat.chattingapp.controller;

import com.chat.chattingapp.domain.ChatMessage;
import com.chat.chattingapp.domain.MessageWriteResponse;
import com.chat.chattingapp.domain.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatContoller {
    private List<ChatMessage> chatMessages = new ArrayList<>();

    @PostMapping("/message")
    public Result<MessageWriteResponse> writeMessage(){
        ChatMessage chatMessage = new ChatMessage("홍길동", "안녕하세요.");
        chatMessages.add(chatMessage);
        return new Result<>(
                "S-1",
                "메세지가 작성되었습니다.",
                new MessageWriteResponse(chatMessage.getId())
        );
    }
}
