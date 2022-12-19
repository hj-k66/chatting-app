package com.chat.chattingapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MessageResponse {
    private List<ChatMessage> messages;
    private int count;
}
