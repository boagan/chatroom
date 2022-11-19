package com.sample.stomp.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ChatRoom {

    private String roomId;
    private String roomName;


    public static ChatRoom create(String name, String roomId) {
        ChatRoom room = new ChatRoom();
        if(roomId == "new"){
            room.roomId = UUID.randomUUID().toString();
        }else {
            room.roomId = roomId;
        }
        room.roomName = name;
        return room;
    }
}