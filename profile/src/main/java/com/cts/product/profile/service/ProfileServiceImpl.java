package com.cts.product.profile.service;

import org.springframework.stereotype.Service;

import com.cts.product.profile.domain.UserProfile;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Override
	public UserProfile authenticate(String username, String password) {
		UserProfile profile = null;
		if (username.equalsIgnoreCase("john") && password.equals("password1$")) {
			profile = new UserProfile.ProfileBuilder(username)
					.fullName("John Smith")
					.emailId("testemail@mailinator.com")
					.mobileNo("3145125555")
					.build();
		}
		
		return profile;
	}

	@Override
	public UserProfile getUserProfile(String userId) {
		UserProfile profile = new UserProfile.ProfileBuilder(userId)
				.fullName("John Smith")
				.emailId("testemail@mailinator.com")
				.mobileNo("3145125555")
				.addPreference("Fev Movie", "Jo Jeeta Wohi Sikandar")
				.addPreference("Fev Food", "Biriyani")
				.addPreference("Fev Music", "Hindi Songs")
				.build();
		return profile;
	}

}
