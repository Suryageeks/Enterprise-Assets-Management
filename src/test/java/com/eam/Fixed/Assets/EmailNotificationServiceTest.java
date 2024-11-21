package com.eam.Fixed.Assets.notification;

import com.eam.Fixed.Assets.dto.EmailMessageDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class EmailNotificationServiceTest {

    @Autowired
    private EmailNotificationService emailNotificationService;

    @MockBean
    private JavaMailSender javaMailSender;

    @Test
    public void testSendMail() {
        // Create a test EmailMessageDto
        EmailMessageDto emailMessageDto = new EmailMessageDto();
        emailMessageDto.setTo("arya.08.as44@gmail.com");
        emailMessageDto.setCc("arya.08.as44@gmail.com");
        emailMessageDto.setSubject("Test Subject");
        emailMessageDto.setBody("This is a test email body.");

        // Call the service method
        emailNotificationService.sendMail(emailMessageDto);

        // Create the expected SimpleMailMessage
        SimpleMailMessage expectedMessage = new SimpleMailMessage();
        expectedMessage.setTo(emailMessageDto.getTo());
        expectedMessage.setCc(emailMessageDto.getCc());
        expectedMessage.setSubject(emailMessageDto.getSubject());
        expectedMessage.setText(emailMessageDto.getBody());

        // Verify that javaMailSender.send() was called with the expected message
        verify(javaMailSender).send(Mockito.any(SimpleMailMessage.class));
    }
}
