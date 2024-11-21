package com.eam.Fixed.Assets.notification;

import com.eam.Fixed.Assets.dto.EmailMessageDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailProducer {
    private AmqpTemplate amqpTemplate;

    public void sendEmail(EmailMessageDto emailMessageDto) {
        amqpTemplate.convertAndSend("email", emailMessageDto);
    }
}
