package hr.tvz.poljak.hardwareapp.security.service;

import hr.tvz.poljak.hardwareapp.security.domain.User;

public interface JwtService {

    boolean authenticate(String token);

    String createJwt(User user);

}