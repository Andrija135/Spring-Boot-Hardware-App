package hr.tvz.poljak.hardwareapp.review.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
class ReviewControllerTest {

    String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY1NDg3NTg2OSwiaWF0IjoxNjU0MjcxMDY5LCJhdXRob3JpdGllcyI6IlJPTEVfQURNSU4ifQ.7V7CwMnTICp9cEF46CvcHVC2VDhfR-Jy4el4kvEe2tE4Y3HbpglQRLJZwI_vnrFnY2bjfxsqfttWfR-jMtbVDw";


    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllReviews() throws Exception {
        this.mockMvc.perform
                        (get("/reviews")
                                .with(csrf())
                                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                                .accept(MediaType.APPLICATION_JSON)
                        )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(6)));
    }

    @Test
    void getReviewsForHardware() throws Exception {
        this.mockMvc.perform
                        (get("/reviews/KG23JH4G23K4")
                                .with(csrf())
                                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)));
    }

}