package com.cts.product.profile.service;

import com.cts.product.profile.domain.UserProfile;

public interface ProfileService {
	UserProfile authenticate(String username, String password);
	
	UserProfile getUserProfile(String userId);
}
