package com.habin.shinhan_cubeon_task.review.controller;

import com.habin.shinhan_cubeon_task.review.repository.LectureRepository;
import com.habin.shinhan_cubeon_task.review.repository.ReviewRepository;
import com.habin.shinhan_cubeon_task.review.service.ReviewService;
import com.navercorp.fixturemonkey.LabMonkey;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.SharedHttpSessionConfigurer.sharedHttpSession;

@SpringBootTest
@AutoConfigureMockMvc
class ReviewControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private ReviewService reviewService;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private LabMonkey labMonkey;

    @BeforeEach
    void setUp(WebApplicationContext webApplicationContext) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(sharedHttpSession())
                .build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("리스트 조회 API - 조건 없음")
    void list() throws Exception {
        mockMvc.perform(get("/review"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}
