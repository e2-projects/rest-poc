package lt.edas.demo.poc.rest.filters;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class PingFilter implements Filter {

    private final Logger logger;

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        logger.info(servletRequest.getRemoteAddr());
    }
}
