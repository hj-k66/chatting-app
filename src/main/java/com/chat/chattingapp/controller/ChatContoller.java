package com.chat.chattingapp.controller;

import com.chat.chattingapp.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/chat")
public class ChatContoller {
    private List<ChatMessage> chatMessages = new ArrayList<>();

    @GetMapping("/messages")
    public Result<MessageResponse> getmessages(@RequestBody MessageRequest request){
        List<ChatMessage> messages = chatMessages;
        if(request.getFromId() != null){
            int idx = IntStream.range(0,chatMessages.size())
                    .filter(i->chatMessages.get(i).getId() == request.getFromId())
                    .findFirst()
                    .orElse(-1);
            if(idx != -1){
                messages = chatMessages.subList(idx+1,chatMessages.size());
            }
        }
        return new Result<>(
                "S-1",
                "전체 메세지 조회에 성공했습니다.",
                new MessageResponse(messages,messages.size())
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
