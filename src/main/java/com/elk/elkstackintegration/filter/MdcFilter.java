package com.elk.elkstackintegration.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;

import java.io.IOException;
import java.util.UUID;

@WebFilter
public class MdcFilter extends HttpFilter {

    final String CorrelationId = "Correlation-ID";

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException, ServletException, IOException {
        try {
            String correlationId = getCorrelationId();
            MDC.put("CorrelationId", correlationId);
            response.addHeader(CorrelationId, correlationId);
            filterChain.doFilter(request, response);
        } finally {
            MDC.remove("CorrelationId");
        }
    }

    public String getCorrelationId() {
        return UUID.randomUUID().toString();
    }
}
