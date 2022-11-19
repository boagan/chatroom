package com.sample.stomp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class RoomEntity {


    @Column(length = 200)
    private String Roomname;

    @Id
    @Column(columnDefinition = "TEXT")
    private String Roomid;


    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE)
    private List<MessageEntity> messageList;

}
