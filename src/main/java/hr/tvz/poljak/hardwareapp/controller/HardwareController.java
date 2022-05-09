package hr.tvz.poljak.hardwareapp.controller;


import hr.tvz.poljak.hardwareapp.dto.HardwareDTO;
import hr.tvz.poljak.hardwareapp.model.HardwareCommand;
import hr.tvz.poljak.hardwareapp.service.HardwareService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("hardware")
public class HardwareController {

    private final HardwareService hardwareService;

    public HardwareController(HardwareService hardwareService) {
        this.hardwareService = hardwareService;
    }

    @GetMapping
    public List<HardwareDTO> getAllHardwares() {
        return hardwareService.findAll();
    }

    @GetMapping(("/{code}"))
    public ResponseEntity<HardwareDTO> getHardwareByCode(@PathVariable final String code) {
        return hardwareService
                .findByCode(code)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HardwareDTO> save(@Valid @RequestBody final HardwareCommand command) {
        return hardwareService
                .save(command)
                .map(hardwareDTO -> ResponseEntity.status(HttpStatus.CREATED).body(hardwareDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PutMapping("/{code}")
    public ResponseEntity<HardwareDTO> update(@PathVariable String code, @Valid @RequestBody final HardwareCommand updatedHardwareCommand) {
        return hardwareService
                .update(code, updatedHardwareCommand)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{code}")
    public void delete(@PathVariable String code) {
        hardwareService.deleteByCode(code);
    }
}
