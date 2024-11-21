package com.eam.Fixed.Assets.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmailMessageDto {
    private String to;
    private String cc;
    private String subject;
    private String body;
//    private String template;
}
