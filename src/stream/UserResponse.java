package stream;

public class UserResponse {

    private Long userKey;
    private String userName;
    private String userEmail;

    public UserResponse(Long userKey, String userName, String userEmail) {
        this.userKey = userKey;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public Long getUserKey() {
        return userKey;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "userKey=" + userKey +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }

    public static UserResponse toUserResponse(UserEntity userEntity) {
        return new UserResponse(userEntity.getId(), userEntity.getName(), userEntity.getEmail());
    }
}
