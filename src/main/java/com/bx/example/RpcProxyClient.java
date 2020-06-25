package com.bx.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RpcProxyClient {
    public <T> T clientProxy(final Class<T> interFace,final String host,final int port){
        return (T) Proxy.newProxyInstance(interFace.getClassLoader(), new Class<?>[]{interFace}, new RemoteInvocationHandler(host,port));
    }
}
