package com.bx.example;

import com.bx.example.RpcRequest;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RemoteInvocationHandler implements InvocationHandler {
    private String host;
    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        RpcNetTransport rpcNetTransport = new RpcNetTransport(host,port);
        rpcNetTransport.newSocket();
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setArgs(args);
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setType(method.getParameterTypes());
        rpcRequest.setMethodName(method.getName());
        return rpcNetTransport.send(rpcRequest);
    }
}
