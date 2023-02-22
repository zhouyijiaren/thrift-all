package com.yangyang.thrift.server.thrift;

import com.yangyang.thrift.server.gen.HelloService;
import com.yangyang.thrift.support.annotions.EnableThriftServer;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

@Service
@EnableThriftServer
public class HelloServiceImpl implements HelloService.Iface {

    @Override
    public String sayHello() throws TException {
        return "Hello,World";
    }

    @Override
    public String sayName(String name) throws TException {
        return "hello," + name;
    }
}
