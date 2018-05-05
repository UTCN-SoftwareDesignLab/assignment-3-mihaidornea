package hospitalApplication.mapper;

import hospitalApplication.dto.UserDto;
import hospitalApplication.dto.builder.UserDtoBuilder;
import hospitalApplication.entity.User;
import hospitalApplication.entity.builder.UserBuilder;

public class UserMapper implements Mapper<User, UserDto> {

    @Override
    public User mapTo (UserDto userDto) {
        User user = new UserBuilder()
                .setEmail(userDto.getEmail())
                .setUsername(userDto.getUsername())
                .setPassword(userDto.getPassword())
                .setRole(userDto.getRole())
                .build();
        return user;
    }

    @Override
    public UserDto mapFrom(User user) {
        UserDto userDto = new UserDtoBuilder()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setRole(user.getRole())
                .setUsername(user.getUsername())
                .build();
        return userDto;
    }


}
