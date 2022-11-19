package com.sample.stomp.Repository;

import com.sample.stomp.model.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<RoomEntity, Integer>{
    //RoomEntity findByRoomid(String Roomid);
}
