package com.cos.securityex01.config.oauth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

// OAuth2 로그인할 때의 서비스.
public class PrincipalOauth2UserService extends DefaultOAuth2UserService{
	
	// loaduser해야됨, 데이터 타입이 OAuth2User면 세션 두개 관리해야됨 데이터타입 두개라서
	// userRequest는 code를 받아서 access Token을 응답받은 객체
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2User oAuth2User = super.loadUser(userRequest); // google의 회원프로필
		//oAuth2User 정보 리턴을 principalDetails로 리턴해준다
		// 1번: PrincipalDetails에 OAuth2User 정보를 집어 넣어준다.
		// 2번: 데이터타입 PrincipalDetails를 리턴한다.
		System.out.println("oAuth2User: " + oAuth2User); // 토큰을 통해 응답받은 회원정보.
		System.out.println("userRequest token : " + userRequest.getAccessToken().getTokenValue());
		System.out.println("userRequest clientRegistration : " + userRequest.getClientRegistration());
		//보면 토큰 이미 들어가 있다는걸 알 수 있다. 따라서 OAuth2UserRequest에 이미 여러 처리를 거쳐서 토큰을 받았다. 
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return super.loadUser(userRequest);
	}
	
	
	private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {
		
		// 일반적으로 로그인할 때 유저 정보 User
		// 1. OAuth2로 로그인할 때 유저 정보 attributes <- 이거 구성해야함.
		// 2. DB에 이사람 있는지 확인
		
		// 있으면? -> 유저정보 업데이트 (구글에서 데이터 변경 일어날수 있으니까)
		
		
		// 없으면 ->  Insert해야함
		
		
		// return PrincipalDetails(); 
		return null;
	}
	
	
}
