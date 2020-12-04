package love.moon.service;

import love.moon.dto.MessageDTO;

public interface KafkaService {

    void send(MessageDTO newsDTO);
}
