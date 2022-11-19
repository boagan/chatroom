package com.sample.stomp.service;


import com.sample.stomp.Repository.RoomRepository;
import com.sample.stomp.model.ChatRoom;
import com.sample.stomp.model.RoomEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatService {

    private Map<String, ChatRoom> chatRooms;

    @Autowired
    private RoomRepository roomRepository;

    @PostConstruct
    //의존관게 주입완료되면 실행되는 코드
    private void init() {
        chatRooms = new LinkedHashMap<>();

        List<RoomEntity> all = this.roomRepository.findAll();

        for(int i=0; i < all.size(); ++i){
            ChatRoom chatRoom = ChatRoom.create(all.get(i).getRoomname(),all.get(i).getRoomid());
            chatRooms.put(chatRoom.getRoomId(), chatRoom);

        }
    }

    public String findrealroom(){

        List<RoomEntity> all = this.roomRepository.findAll();
        return all.get(1).getRoomid();
    }

    //채팅방 불러오기
    public List<ChatRoom> findAllRoom() {
        //채팅방 최근 생성 순으로 반환
        List<ChatRoom> result = new ArrayList<>(chatRooms.values());
        Collections.reverse(result);

        return result;
    }

    //채팅방 하나 불러오기
    public ChatRoom findById(String roomId) {


        return chatRooms.get(roomId);
    }

    //채팅방 생성
    public ChatRoom createRoom(String name) {
        ChatRoom chatRoom = ChatRoom.create(name,"new");
        chatRooms.put(chatRoom.getRoomId(), chatRoom);

        //test
        RoomEntity r1 = new RoomEntity();
        r1.setRoomname(name);
        r1.setRoomid(chatRoom.getRoomId());
        this.roomRepository.save(r1);
        return chatRoom;
    }
    /*
    public RoomEntity getChatRoom(String roomid) {


        RoomEntity chatroom = this.roomRepository.findByRoomid(roomid);

        return chatroom;

    }
*/
}