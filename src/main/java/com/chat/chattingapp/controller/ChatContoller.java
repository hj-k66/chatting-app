package com.chat.chattingapp.controller;

import com.chat.chattingapp.domain.ChatMessage;
import com.chat.chattingapp.domain.MessageWriteRequest;
import com.chat.chattingapp.domain.MessageWriteResponse;
import com.chat.chattingapp.domain.Result;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatContoller {
    private List<ChatMessage> chatMessages = new ArrayList<>();

    @GetMapping("/messages")
    public Result<List<ChatMessage>> getmessages(){
        return new Result<>(
                "S-1",
                "전체 메세지 조회에 성공했습니다.",
                chatMessages
        );
    }
    @PostMapping("/message")
    public Result<MessageWriteResponse> writeMessage(@RequestBody MessageWriteRequest request){
        ChatMessage chatMessage = new ChatMessage(request.getAuthorName(), request.getContent());
        chatMessages.add(chatMessage);
        return new Result<>(
                "S-1",
                "메세지가 작성되었습니다.",
                new MessageWriteResponse(chatMessage.getId())
        );
    }
}
