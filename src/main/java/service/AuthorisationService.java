package service;

import bootstrap.Application;
import entity.User;
import lombok.AllArgsConstructor;
import org.apache.commons.codec.digest.HmacUtils;


import java.util.List;
import java.util.UUID;

import static org.apache.commons.codec.digest.HmacAlgorithms.HMAC_SHA_224;

@AllArgsConstructor
public class AuthorisationService {
    private final String secret = "secret";
    private final String table = "users";

    public boolean tryToAuthoriseUser(String name, String password, List<User> users) {
        User user = users
                .parallelStream()
                .filter(u -> u.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> {
                    System.out.println("AuthorisationService.tryToAuthoriseUser | НЕ смогли найти пользователя");
                    return new IllegalArgumentException("Такого пользователя нет");
                });

        String hashedPassword = new HmacUtils(HMAC_SHA_224, secret.getBytes()).hmacHex(password);

        return hashedPassword.equals(user.getPassword());
    }

    }
