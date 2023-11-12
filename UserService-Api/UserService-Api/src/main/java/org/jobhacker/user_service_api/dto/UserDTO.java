package org.jobhacker.user_service_api.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private long id;
    private String username;
    private String email;
    private String phone;
    private boolean active;

}
