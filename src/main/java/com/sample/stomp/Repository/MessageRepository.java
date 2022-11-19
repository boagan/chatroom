package com.sample.stomp.Repository;

import com.sample.stomp.model.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageEntity, Integer>{

}
