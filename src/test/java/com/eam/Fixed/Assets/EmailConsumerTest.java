package com.eam.Fixed.Assets.notification;

import com.eam.Fixed.Assets.dto.EmailMessageDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest
public class EmailConsumerTest {

    @SpyBean
    private EmailConsumer emailConsumer;

    @SpyBean
    private EmailNotificationService emailNotificationService;

    @Test
    public void testReceive() {
        // Create a test EmailMessageDto
        EmailMessageDto emailMessageDto = new EmailMessageDto();
        emailMessageDto.setTo("arya.08.as44@gmail.com");
        emailMessageDto.setCc("arya.08.as44@gmail.com");
        emailMessageDto.setSubject("Test Receive Subject");
        emailMessageDto.setBody("This is a test receive body.");

        // Simulate message reception
        emailConsumer.receive(emailMessageDto);

        // Verify the email service is called with the correct DTO
        Mockito.verify(emailNotificationService).sendMail(emailMessageDto);
    }
}
