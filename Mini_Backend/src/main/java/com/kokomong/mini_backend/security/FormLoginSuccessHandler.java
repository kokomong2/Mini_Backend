package com.kokomong.mini_backend.security;

import com.kokomong.mini_backend.security.jwt.JwtTokenUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {    //로그인이 성공하면 오는 곳.
    public static final String AUTH_HEADER = "Authorization";
    public static final String TOKEN_TYPE = "BEARER";

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
                                        final Authentication authentication) {
        final UserDetailsImpl userDetails = ((UserDetailsImpl) authentication.getPrincipal());
        // Token 생성
        final String token = JwtTokenUtils.generateJwtToken(userDetails);   //토큰을 뽑아와서
        System.out.println(userDetails.getUsername() + "'s token : " + TOKEN_TYPE + " " + token);
        response.addHeader(AUTH_HEADER, TOKEN_TYPE + " " + token);
        System.out.println("LOGIN SUCCESS!");
    }

}
