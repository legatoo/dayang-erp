# dayang-erp
A Spring-boot Application Demo

如何把spring boot服务做成一个服务，由systemctl管理

由于工程使用的spring profile，但是打包用的是mvn，因此需要使用插件spring-boot-maven-plugin

```xml
<plugins>
    <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <executions>
            <execution>
                <goals>
                    <goal>repackage</goal>
                </goals>
            </execution>
        </executions>
        <configuration>
            <executable>true</executable>
        </configuration>
    </plugin>
</plugins>

```

然后使用`mvn clean install spring-boot:repackage`打包，得到可执行的jar包
在`/etc/systemd/system/` 下创建服务的描述单元 `yourservicename.service`

```
[Unit]
Description=xxxxxxxxxxxx
After=syslog.target

[Service]
User=steven
ExecStart=/xxxxxxx/xxxxxxx.jar
SuccessExitStatus=143
Restart=always

[Install]
WantedBy=multi-user.target

```

但是在运行的时候，我们得指明使用的是哪个spring profile，这个时候需要把相关环境变量传递给jar包做法是把相关变量放到一个`.conf`文件种，这个文件需要和jar包名字一样。最方便的做法是把这个文件和jar包放在一起，但是jar包一般打在target文件夹中，which我们的git一般会ignore，那么我们把配置文件放在target不是一个很好的做法是需要做的是先定义`CONF_FOLDER`变量在我们的系统环境中，添加如下内容到 `~/.profile`

```bash
export CONF_FOLDER="your conf file location"
```
然后source这个文件生效 CONF_FOLDER

然后把实际要传递给jar包的配置写成一个 .conf 文件放到上面配置的地址。比如这个项目的相关参数是
```bash
export JAVA_OPTS="-server -Xms512m -Xmx512m -XX:MaxMetaspaceSize=128m -Dspring.profiles.active=dev"
```

然后使用命令 

```bash
sudo systemctl start yourservicename
```
如果服务没有起来，使用下面命令看日志
```bash
sudo journalctl -u yourservicename
```
如果想让服务自动启动，首先在service的描述文件里面的service section添加`Restart=always`
然后执行以下命令
```bash
sudo systemctl daemon-reload
sudo systemctl enable yourservicename
sudo systemctl restart yourservicename
```
