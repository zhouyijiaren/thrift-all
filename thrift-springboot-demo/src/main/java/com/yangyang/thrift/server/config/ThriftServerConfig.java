// package com.yangyang.thrift.server.config;

// import java.net.InetSocketAddress;

// import org.apache.thrift.transport.TServerSocket;
// import org.apache.thrift.transport.TServerTransport;
// import org.apache.thrift.transport.TTransportException;
// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// @ConfigurationProperties(prefix = "thrift.server")
// public class ThriftServerConfig {

//     int port;

//     String ipAddress;

//     public String getIpAddress() {
//         return ipAddress;
//     }

//     public void setIpAddress(String ipAddress) {
//         this.ipAddress = ipAddress;
//     }

//     public int getPort() {
//         return port;
//     }

//     public void setPort(int port) {
//         this.port = port;
//     }

//     @Bean
//     public TServerTransport tServerTransport() throws TTransportException {
//         return new TServerSocket(new InetSocketAddress(ipAddress, port));
//     }
// }
