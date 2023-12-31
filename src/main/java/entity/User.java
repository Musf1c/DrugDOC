package entity;

import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@ToString
@Getter
@Setter
public class User {
    public UUID id;
    public String name;
    public String password;

}
