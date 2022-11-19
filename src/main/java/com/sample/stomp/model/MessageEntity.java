package com.sample.stomp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;




    @Column(length = 200)
    private String sender;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(length = 200)
    private String Roomid;


    @ManyToOne
    private RoomEntity room;


}
