package hr.tvz.poljak.hardwareapp.hardware.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tvz.poljak.hardwareapp.hardware.model.Hardware;
import hr.tvz.poljak.hardwareapp.hardware.model.HardwareType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
class HardwareControllerTest {

    String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY1NDg3NTg2OSwiaWF0IjoxNjU0MjcxMDY5LCJhdXRob3JpdGllcyI6IlJPTEVfQURNSU4ifQ.7V7CwMnTICp9cEF46CvcHVC2VDhfR-Jy4el4kvEe2tE4Y3HbpglQRLJZwI_vnrFnY2bjfxsqfttWfR-jMtbVDw";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllHardwares() throws Exception {
        this.mockMvc.perform
                        (get("/hardware")
                                .with(csrf())
                                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                                .accept(MediaType.APPLICATION_JSON)
                        )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(7)));
    }

    @Test
    void getHardwareByCode() throws Exception {
        Hardware testHardware = new Hardware("Intel Pentium", "KG23JH4G23K4", BigDecimal.valueOf(100.00), HardwareType.CPU, 10);
        this.mockMvc.perform(get("/hardware/KG23JH4G23K4"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(testHardware.getName()))
                .andExpect(jsonPath("$.code").value(testHardware.getCode()))
                .andExpect(jsonPath("$.price").value(testHardware.getPrice()));
    }


    @Test
    @Transactional
    void save() throws Exception {
        Map<String, Object> body = new HashMap<>();
        body.put("name", "PachoKomadHardvera");
        body.put("code", "pachoCode");
        body.put("price", 937.00);
        body.put("type", "CPU");
        body.put("stock", 45);


        this.mockMvc.perform(
                        post("/hardware")
                                .with(csrf())
                                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(body))
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("PachoKomadHardvera"))
                .andExpect(jsonPath("$.code").value("pachoCode"))
                .andExpect(jsonPath("$.price").value(937.00));
    }
}