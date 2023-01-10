package com.habin.shinhan_cubeon_task.common.jpa;

import com.habin.shinhan_cubeon_task.review.entity.Lecture;
import com.habin.shinhan_cubeon_task.review.repository.LectureRepository;
import com.habin.shinhan_cubeon_task.review.repository.ReviewRepository;
import com.habin.shinhan_cubeon_task.user.entity.User;
import com.habin.shinhan_cubeon_task.user.repository.UserRepository;
import com.navercorp.fixturemonkey.LabMonkey;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData {

    private final UserRepository userRepository;
    private final LectureRepository lectureRepository;
    private final ReviewRepository reviewRepository;
    private final LabMonkey labMonkey;

    @PostConstruct
    @Transactional
    public void initLectureData() {
        Lecture lecture = Lecture.builder()
                .lectureId(1)
                .lectureName("스프링 부트와 JPA로 초간단 API 개발하기")
                .teacher("신한큐브온")
                .difficulty("초급")
                .lecturePeriod("무제한")
                .build();

        lectureRepository.save(lecture);
    }

    @PostConstruct
    @Transactional
    public void initUserData() {
        List<User> users = labMonkey.giveMe(User.class, 10);
        userRepository.saveAll(users);
    }

}
