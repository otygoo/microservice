package nuctech.bigdata.apigateway.filters;


import com.netflix.zuul.ZuulFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

/*
    路由之前的过滤器
*/
@Component
public class Routing_pre extends ZuulFilter{

    private static Logger log = LoggerFactory.getLogger(Routing_pre.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // RequestContext ctx = RequestContext.getCurrentContext();
		// return !ctx.containsKey(FORWARD_TO_KEY) // a filter has already forwarded
        //         && !ctx.containsKey(SERVICE_ID_KEY); // a filter has already determined serviceId
                
        return false;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                //ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }
        log.info("ok");
        return null;
    }

}

