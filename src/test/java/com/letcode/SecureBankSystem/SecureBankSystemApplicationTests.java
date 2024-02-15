package com.letcode.SecureBankSystem;

import com.letcode.SecureBankSystem.entity.GuestEntity;
import com.letcode.SecureBankSystem.entity.UserEntity;
import com.letcode.SecureBankSystem.repository.GuestSuggestionRepository;
import com.letcode.SecureBankSystem.repository.UserRepository;
import com.letcode.SecureBankSystem.service.guestSuggestion.GuestSuggestionService;
import com.letcode.SecureBankSystem.service.user.UserService;
import com.letcode.SecureBankSystem.util.enums.suggestion.SuggestionStatus;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SecureBankSystemApplicationTests {
	@MockBean  // a copy of the original data to test it will not save in the database
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Mock
	private GuestSuggestionRepository guestSuggestionRepository;

	@InjectMocks
	private GuestSuggestionService guestSuggestionService;


	@Test
	public void whenCreateStatusSuggestions_ThenSuccess(){
		GuestEntity suggestion = new GuestEntity();
		suggestion.setGuestSuggestionText("create suggestion");


		GuestEntity suggestion1 = new GuestEntity();
		suggestion1.setGuestSuggestionText("create suggestion");

		List<UserEntity> sugg = Arrays.asList(suggestion,suggestion1);


	}
	@Test
	public void whenRemoveStatusSuggestions_ThenSuccess(){
		GuestEntity suggestion = new GuestEntity();
		suggestion.setGuestSuggestionText("remove");

		GuestEntity suggestion1 = new GuestEntity();
		suggestion1.setGuestSuggestionText("remove ");

	}
	@Test
	public void whenUsersPasswordIsLargerThan8Digit_ThenSuccess(){
		UserEntity userEntity1 = new UserEntity();
		userEntity1.setName("Thaer");
		userEntity1.setPassword("1234ee56789");

		UserEntity userEntity2 = new UserEntity();
		userEntity2.setName("Abd");
		userEntity2.setPassword("867e5w7w6");

		UserEntity userEntity3 = new UserEntity();
		userEntity3.setName("Sara");
		userEntity3.setPassword("123");

		List<UserEntity> moksUserEntities = Arrays.asList(userEntity1,userEntity2,userEntity3);

		Mockito.when(userRepository.findAll()).thenReturn(moksUserEntities);   // mikto is a copy


		//Act the logic of the test

		List<String> userWithStrongPassword = userService.getAllUsersWithStrongPassword();

		//Assert
		List<String> expectedUsersWithStrongPassword = Arrays.asList("Thaer","Abd");  //their password is more than 8

		assertEquals(expectedUsersWithStrongPassword,userWithStrongPassword);






//		List<UserEntity> mockUserPassword = Arrays.asList(
//				new UserEntity("")
//		)

	}

}
