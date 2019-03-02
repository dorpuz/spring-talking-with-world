package pl.edu.wszib.springtalkingwithworld.Lab3;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
//@Scope(SCOPE_PROTOTYPE)
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Ciastki {

    private boolean zjedzone = false;

    public boolean isZjedzone() {
        return zjedzone;
    }
    public void zjedz(){
        zjedzone = true;
    }
}
