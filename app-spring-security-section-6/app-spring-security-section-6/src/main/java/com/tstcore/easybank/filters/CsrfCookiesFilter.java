package com.tstcore.easybank.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class CsrfCookiesFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //-- read the available csrf token inside the HttpServletRequest
        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        //-- check if we do have header-name in this CsrfToken
        if (null != csrfToken.getHeaderName()) {
            response.setHeader(csrfToken.getHeaderName(), csrfToken.getToken());
        }
        //-- handing over, the response, to the next security filter
        filterChain.doFilter(request, response);
    }
}
