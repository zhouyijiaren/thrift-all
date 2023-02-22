package com.yangyang.thrift.server.thrift;

import com.yangyang.thrift.server.gen.UserService;
import com.yangyang.thrift.support.annotions.EnableThriftServer;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
@EnableThriftServer
public class UserServiceImpl implements UserService.Iface {

    @Override
    public List<String> findAll() throws TException {
        return Arrays.asList(new String[] { "a", "b" });
    }
}
