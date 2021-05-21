package ru.gb.artem.marketapril.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserDto {
    private String username;
    private String email;
    private String password;

    public UserDto(String username, String email) {
        this.username = username;
        this.email = email;
    }

}
