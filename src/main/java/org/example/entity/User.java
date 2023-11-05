package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@AllArgsConstructor
public class User {
    public UUID id;
    public String nameUser;
    public String passwordUser;

}
