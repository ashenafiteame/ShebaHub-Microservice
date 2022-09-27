package com.example.shebahubuser.authentication.filter;

import com.example.shebahubuser.authentication.jwt.JWTUtil;
import com.example.shebahubuser.authentication.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTRequestFilter extends OncePerRequestFilter {
    @Autowired
    private MyUserDetailService userDetailService;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");
        System.out.println("Must output");
//        request.getMethod()
        System.out.println(authorizationHeader);
        String username = null;
        String jwt  = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            jwt = authorizationHeader.substring(7);
            System.out.println("**************************");
            System.out.println("JWT "+ jwt);
            username = jwtUtil.extractUsername(jwt);
            System.out.println("UserName "+ username);
            System.out.println("**************************");


        }
        System.out.println(SecurityContextHolder.getContext().getAuthentication() == null);
        System.out.println(username);
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            System.out.println(username != null);
            UserDetails userDetails = this.userDetailService.loadUserByUsername(username);
            System.out.println("User Detail" + userDetails.getUsername());
            if (jwtUtil.validateToken(jwt, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request,response);

    }
}
