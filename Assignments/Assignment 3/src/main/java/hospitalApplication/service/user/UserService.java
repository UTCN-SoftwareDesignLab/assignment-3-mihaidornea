package hospitalApplication.service.user;

import hospitalApplication.dto.UserDto;
import hospitalApplication.entity.User;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();
    UserDto findByUsername(String username);
    UserDto findByEmail(String email);
    boolean create(UserDto userDto);
    boolean deleteByUsername(UserDto userDto);
    boolean update(UserDto userDto, String newUsername);
}
