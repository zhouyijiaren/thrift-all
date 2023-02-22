namespace java com.yangyang.thrift.server.gen

service UserService
{
    list<string> findAll()
}

service HelloService
{
    string sayHello(),
    string sayName(string name)
}