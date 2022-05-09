package hr.tvz.poljak.hardwareapp.controller;


import hr.tvz.poljak.hardwareapp.dto.HardwareDTO;
import hr.tvz.poljak.hardwareapp.service.HardwareService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(params = "code")
    public Optional<HardwareDTO> getHardwareByDTO(@RequestParam final String code) {
        return hardwareService.findByCode(code);
    }



    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{code}")
    public void delete(@PathVariable String code){
        hardwareService.deleteByCode(code);
    }
}
