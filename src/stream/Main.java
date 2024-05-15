package stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        /*
         * 조회된 엔티티 리스트를 Stream을 통해 응답 객체 리스트로 변환
         */

        // 사용자 엔티티 객체 생성
        UserEntity userEntity1 = makeUserEntity(1L, "사용자1", "user001@gmail.com", "normal");
        UserEntity userEntity2 = makeUserEntity(2L, "사용자2", "user002@gmail.com", "normal");
        UserEntity userEntity3 = makeUserEntity(3L, "사용자3", "user003@gmail.com", "premium");
        UserEntity userEntity4 = makeUserEntity(4L, "사용자4", "user004@gmail.com", "premium");
        UserEntity userEntity5 = makeUserEntity(5L, "사용자5", "user005@gmail.com", "premium");

        // 사용자 인티티 리스트
        List<UserEntity> userEntities = List.of(userEntity1, userEntity2, userEntity3, userEntity4, userEntity5);

        // Stream을 통해 응답 객체 변환
        List<UserResponse> userResponses = userEntities.stream()
                                                       .map(UserResponse::toUserResponse)
                                                       .sorted(Comparator.comparing(UserResponse::getUserKey).reversed()) // 내림차순 정렬
                                                       .collect(Collectors.toList());

        System.out.println("전체 사용자 목록 조회 (사용자 키 내림차순) => " + userResponses.toString());

        // Stream을 통해 premium type인 사용자 정보만을 추출
        List<UserResponse> premiumUserResponses = userEntities.stream()
                                                              .filter(userEntity -> "premium".equals(userEntity.getType()))
                                                              .map(UserResponse::toUserResponse)
                                                              .sorted(Comparator.comparing(UserResponse::getUserKey).reversed())
                                                              .collect(Collectors.toList());

        System.out.println("premium 사용자 목록 조회 (사용자 키 내림차순) => " + premiumUserResponses.toString());
    }

    public static UserEntity makeUserEntity(Long id, String name, String email, String type) {
        return new UserEntity(id, name, email, type);
    }
}
