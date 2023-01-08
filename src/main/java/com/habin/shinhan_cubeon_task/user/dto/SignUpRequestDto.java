package com.habin.shinhan_cubeon_task.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDto {

    @NotBlank(message = "사용자 ID를 입력하지 않으셨습니다.")
    @Size(max = 20, message = "사용자 ID는 20자 이하로 입력해주세요.")
    private String userId;

    @NotBlank(message = "사용자 닉네임을 입력하지 않으셨습니다.")
    @Size(max = 10, message = "사용자 닉네임은 10자 이하로 입력해주세요.")
    private String nickname;

    @NotBlank(message = "사용자 프로필 썸네일 URL을 입력하지 않으셨습니다.")
    @Size(max = 50, message = "사용자 프로필 썸네일 URL은 50자 이하로 입력해주세요.")
    private String profileThumbnailUrl;

}
