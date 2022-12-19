package com.chat.chattingapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Result<T> {
    private String resultCode;
    private String msg;
    private T data;
}
