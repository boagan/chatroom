package com.sample.stomp.controller;


import com.sample.stomp.model.ChatMessage;
import com.sample.stomp.model.ChatRoom;
import com.sample.stomp.model.MessageEntity;
import com.sample.stomp.model.RoomEntity;
import com.sample.stomp.service.ChatService;
import com.sample.stomp.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatRoomController {

    // 채팅과 메세지 서비스
    private final ChatService chatService;
    private final MessageService messageService;

    // 채팅 리스트 화면
    @GetMapping("/room")
    public String rooms(Model model) {
        return "/chat/room";
    }
    // 모든 채팅방 목록 반환
    @GetMapping("/rooms")
    @ResponseBody
    public List<ChatRoom> room() {
        return chatService.findAllRoom();
    }
    // 채팅방 생성
    @PostMapping("/room")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam String name) {
        return chatService.createRoom(name);
    }
    // 채팅방 입장 화면
    @GetMapping("/room/enter/{roomId}")
    public String roomDetail(Model model, @PathVariable String roomId) {
        model.addAttribute("roomId", roomId);
        model.addAttribute("realid",chatService.findrealroom());
        return "/chat/roomdetail";
    }
    // 메세지 생성
    @PostMapping("/room/enter/{roomId}")
    @ResponseBody
    public ChatMessage sendMessage(@RequestParam String m,@RequestParam String sender,@RequestParam String roomId){
        //RoomEntity chatroom = this.chatService.getChatRoom(roomId);
        return messageService.sendMessage(roomId,m,sender);
    }

    // 특정 채팅방 조회
    @GetMapping("/room/{roomId}")
    @ResponseBody
    public ChatRoom roomInfo(@PathVariable String roomId) {
        return chatService.findById(roomId);
    }
    
    // 모든 메세지 목록 반환
    @GetMapping("/messages")
    @ResponseBody
    //public List<ChatMessage> message() {return messageService.findAllMessage();}
    public List<ChatMessage> message() {return messageService.findAllMessage();}
    
    
}