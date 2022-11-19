package com.sample.stomp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    public enum MessageType {
        ENTER, TALK
    }

    private MessageType type;
    //채팅방 ID
    private String roomId;
    //보내는 사람
    private String sender;
    //내용
    private String message;

    public static ChatMessage create(String roomId,String m) {
        ChatMessage message = new ChatMessage();
        //message.type = MessageType.TALK;
        message.roomId = roomId;
        message.message = m;
        return message;
    }
}