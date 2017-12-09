
package genericCheckpointing.util;

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

