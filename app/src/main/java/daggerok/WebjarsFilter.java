package daggerok;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Slf4j
//@WebFilter(urlPatterns = {"/*"}) // Just a filter example. Skip it!
public class WebjarsFilter implements Filter {

  private static final Supplier<Stream<String>> paths = () -> Stream.of("/webjars/", "/static", "/resources");

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    String uri = req.getRequestURI();
    if (paths.get().noneMatch(uri::contains))
      chain.doFilter(request, response);
    else {
      String target = uri.replaceFirst("/", "");
      log.info("going to replace '{}' with '{}'...", uri, target);
      request.getRequestDispatcher(target).forward(request, response);
    }
  }

  @Override
  public void init(FilterConfig config) throws ServletException { }

  @Override
  public void destroy() { }
}
