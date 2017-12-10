
package genericCheckpointing.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import genericCheckpointing.server.StoreRestoreI;

public class ProxyCreator {
    
	public StoreRestoreI createProxy(Class<?>[] interfaces, InvocationHandler handler) {
		return (StoreRestoreI) Proxy.newProxyInstance(
            getClass().getClassLoader(),
            interfaces,
            handler
        );
	}
	
}

