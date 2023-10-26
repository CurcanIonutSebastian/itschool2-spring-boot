package ro.itschool.project.unit_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.itschool.project.models.dtos.UserDTO;
import ro.itschool.project.models.entities.User;
import ro.itschool.project.repositories.UserRepository;
import ro.itschool.project.services.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testCreateUser() {
        //given
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setFirstName("John");
        userDTO.setLastName("Doe");
        userDTO.setEmail("john@gmail.com");

        User user = new User();
        user.setId(1L);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john@gmail.com");

        User saveUserEntity = new User();
        saveUserEntity.setId(1L);
        saveUserEntity.setFirstName("John");
        saveUserEntity.setLastName("Doe");
        saveUserEntity.setEmail("john@gmail.com");

        when(objectMapper.convertValue(userDTO, User.class)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(saveUserEntity);
        when(objectMapper.convertValue(saveUserEntity, UserDTO.class)).thenReturn(userDTO);

        //when
        UserDTO saveUserDTO = userService.createUser(userDTO);

        //then
        verify(userRepository, times(1)).save(user);
        assertEquals(userDTO, saveUserDTO);
    }
}