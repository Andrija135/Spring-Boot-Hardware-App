package hr.tvz.poljak.hardwareapp.hardware.controller;


import hr.tvz.poljak.hardwareapp.hardware.model.HardwareCommand;
import hr.tvz.poljak.hardwareapp.hardware.model.HardwareDTO;
import hr.tvz.poljak.hardwareapp.hardware.service.HardwareService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("hardware")
@CrossOrigin(origins = "http://localhost:4200")
public class HardwareController {

    private final HardwareService hardwareService;

    public HardwareController(HardwareService hardwareService) {
        this.hardwareService = hardwareService;
    }

    @GetMapping
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public List<HardwareDTO> getAllHardwares() {
        return hardwareService.findAll();
    }

    @GetMapping("/{code}")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public ResponseEntity<HardwareDTO> getHardwareByCode(@PathVariable final String code) {
        return hardwareService
                .findByCode(code)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<HardwareDTO> save(@Valid @RequestBody final HardwareCommand command) {
        return hardwareService
                .save(command)
                .map(hardwareDTO -> ResponseEntity.status(HttpStatus.CREATED).body(hardwareDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PutMapping("/{code}")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<HardwareDTO> update(@PathVariable String code, @Valid @RequestBody final HardwareCommand updatedHardwareCommand) {
        return hardwareService
                .update(code, updatedHardwareCommand)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{code}")
    @Secured({"ROLE_ADMIN"})
    public void delete(@PathVariable String code) {
        hardwareService.deleteByCode(code);
    }
}
