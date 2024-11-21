package com.eam.Fixed.Assets.notification;

import com.eam.Fixed.Assets.dto.EmailMessageDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    private final EmailNotificationService emailNotificationService;
    public EmailConsumer(EmailNotificationService emailNotificationService) {
        this.emailNotificationService = emailNotificationService;
    }
    @RabbitListener(queues = "${rabbitmq.queue.email.name}")
    public void receive(EmailMessageDto emailMessageDto) {
        emailNotificationService.sendMail(emailMessageDto);
    }
}
