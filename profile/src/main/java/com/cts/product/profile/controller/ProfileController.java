package com.cts.product.profile.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.product.profile.domain.BaseResponse;
import com.cts.product.profile.domain.UserProfile;
import com.cts.product.profile.service.ProfileService;

@RestController
@RequestMapping("/")
@ComponentScan(basePackages= {"com.cts.product.profile"})
public class ProfileController {
	private static final Logger LOG = LoggerFactory.getLogger(ProfileController.class);
	
	@Autowired
	private ProfileService profileService;
	
	@RequestMapping (value = "/login", 
			method = {RequestMethod.GET, RequestMethod.POST},
			produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse<UserProfile> userlogin(
			@RequestParam(name="username", required=true, defaultValue="") String username,
			@RequestParam(name="password", required=true, defaultValue="") String password) {
		LOG.debug("Inside userlogin(");

		BaseResponse<UserProfile> bp = new BaseResponse<>();
		UserProfile profile = profileService.authenticate(username, password);
		if (profile == null) {
			bp.setServiceError("2001", "ERROR", "Invalid User Login");
		} else {
			bp.setSuccess(true);
			bp.setResponse(profile);
		}
		return bp;
	}
	
	
	@RequestMapping (
			value = "/getprofile", 
			method = {RequestMethod.GET},
			produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse<UserProfile> getProfile(
			@RequestParam(name="userid", required=true, defaultValue="") String userId) {
		LOG.debug("Inside getProfile(");
		BaseResponse<UserProfile> bp = new BaseResponse<>();
		
		if (StringUtils.isEmpty(userId)) {
			bp.setServiceError("2002", "INFO", "Profile Not Found");
		} else {
			UserProfile profile = profileService.getUserProfile(userId);
			bp.setResponse(profile);
			bp.setSuccess(true);
		}
		return bp;
	}
	
}
