package hr.tvz.poljak.hardwareapp.security.service;

import hr.tvz.poljak.hardwareapp.security.command.LoginCommand;
import hr.tvz.poljak.hardwareapp.security.dto.LoginDTO;

import java.util.Optional;

public interface AuthenticationService {

    Optional<LoginDTO> login(LoginCommand command);

}