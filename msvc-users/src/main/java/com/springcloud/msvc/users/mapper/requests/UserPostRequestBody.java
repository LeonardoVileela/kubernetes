package com.springcloud.msvc.users.mapper.requests;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPostRequestBody {

    @Email
    private String email;

    @NotBlank
    @Size(min = 4)
    private String password;
}
