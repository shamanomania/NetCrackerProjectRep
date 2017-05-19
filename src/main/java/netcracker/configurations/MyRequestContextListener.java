package netcracker.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.annotation.WebListener;

/**
 * Created by sivko on 17.05.2017.
 */
@Configuration
@WebListener
public class MyRequestContextListener extends RequestContextListener {
}
