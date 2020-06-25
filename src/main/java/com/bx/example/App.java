package com.bx.example;


/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
      RpcProxyClient client = new RpcProxyClient();
      IOrderService iOrderService = client.clientProxy(IOrderService.class,"localhost",8080);
     System.out.println(iOrderService.queryOrderList());

    }
}
