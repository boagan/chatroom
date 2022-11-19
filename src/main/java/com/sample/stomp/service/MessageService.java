package com.sample.stomp.service;

import com.sample.stomp.Repository.MessageRepository;
import com.sample.stomp.Repository.RoomRepository;
import com.sample.stomp.model.ChatMessage;
import com.sample.stomp.model.ChatRoom;
import com.sample.stomp.model.MessageEntity;
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
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;
    private RoomRepository roomRepository;
    private Map<String, ChatMessage> chatMessages;

    private final ChatService chatService;
    @PostConstruct
    //의존관게 주입완료되면 실행되는 코드
    private void init() {
        chatMessages = new LinkedHashMap<>();
        List<MessageEntity> all = this.messageRepository.findAll();

        //하나밖에 안들어가지네 왜지?
        for(int i=0; i < all.size(); ++i){
            ChatMessage chatMessage = ChatMessage.create(all.get(i).getRoomid(),all.get(i).getContent());

            chatMessages.put(all.get(i).getRoomid(), chatMessage);
        }


    }

    //메세지 생성
    public ChatMessage sendMessage(String roomId,String m,String sender) {
        ChatMessage chatMessage = ChatMessage.create(roomId,m);
        chatMessages.put(chatMessage.getRoomId() , chatMessage);

        ;
        //test
        MessageEntity m1 = new MessageEntity();
        m1.setContent(m);
        m1.setSender(sender);
        m1.setRoomid(roomId);
        //m1.setRoom(chatRoom);
        this.messageRepository.save(m1);

        return chatMessage;
    }


    //메세지 불러오기
    public List<ChatMessage> findAllMessage() {
        //메세지 최근 생성 순으로 반환
        List<ChatMessage> result = new ArrayList<>(chatMessages.values());
        Collections.reverse(result);

        return result;
    }



}
