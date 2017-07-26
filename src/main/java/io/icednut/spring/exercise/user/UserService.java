package io.icednut.spring.exercise.user;

public interface UserService {
    // CRUD 기능의 메소드 구현
    // 글 상세 조회
    UserDTO getUser(UserDTO dto);
}
