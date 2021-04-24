package com.lijinlin.project.learn.reflection;

public class SystemClassLoading {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        //获取系统类加载器的父类加载器-->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);
        //获取扩展类加载器的父类加载器-->根加载器（C/C++) 获取不到
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //测试当前类是哪个类加载器加载的
        ClassLoader classLoader = Class.forName("com.lijinlin.project.learn.reflection.SystemClassLoading").getClassLoader();
        System.out.println(classLoader);
        //测试JDK内置的类是谁加载的
        ClassLoader objectLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(objectLoader);

        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
        /**
         * D:\java8\jdk1.8.0_25\jre\lib\charsets.jar;
         * D:\java8\jdk1.8.0_25\jre\lib\deploy.jar;
         * D:\java8\jdk1.8.0_25\jre\lib\ext\access-bridge-32.jar;
         * D:\java8\jdk1.8.0_25\jre\lib\ext\cldrdata.jar;
         * D:\java8\jdk1.8.0_25\jre\lib\ext\dnsns.jar;
         * D:\java8\jdk1.8.0_25\jre\lib\ext\jaccess.jar;
         * D:\java8\jdk1.8.0_25\jre\lib\ext\jfxrt.jar;
         * D:\java8\jdk1.8.0_25\jre\lib\ext\localedata.jar;
         * D:\java8\jdk1.8.0_25\jre\lib\ext\nashorn.jar;
         * D:\java8\jdk1.8.0_25\jre\lib\ext\sunec.jar;
         * D:\java8\jdk1.8.0_25\jre\lib\ext\sunjce_provider.jar;
         * D:\java8\jdk1.8.0_25\jre\lib\ext\sunmscapi.jar;
         * D:\java8\jdk1.8.0_25\jre\lib\ext\sunpkcs11.jar;
         * D:\java8\jdk1.8.0_25\jre\lib\ext\zipfs.jar;
         * D:\java8\jdk1.8.0_25\jre\lib\javaws.jar;
         * D:\java8\jdk1.8.0_25\jre\lib\jce.jar;
         * D:\java8\jdk1.8.0_25\jre\lib\jfr.jar;
         * D:\java8\jdk1.8.0_25\jre\lib\jfxswt.jar;
         * D:\java8\jdk1.8.0_25\jre\lib\jsse.jar;
         * D:\java8\jdk1.8.0_25\jre\lib\management-agent.jar;
         * D:\java8\jdk1.8.0_25\jre\lib\plugin.jar;
         * D:\java8\jdk1.8.0_25\jre\lib\resources.jar;
         * D:\java8\jdk1.8.0_25\jre\lib\rt.jar;
         * D:\workspace\self\project\target\classes;
         * D:\workspace\self\project\lib\netty-all-4.1.20.Final.jar;
         * D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\org\springframework\boot\spring-boot-starter-web\2.3.7.RELEASE\spring-boot-starter-web-2.3.7.RELEASE.jar;
         * D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\org\springframework\boot\spring-boot-starter\2.3.7.RELEASE\spring-boot-starter-2.3.7.RELEASE.jar;
         * D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\org\springframework\boot\spring-boot\2.3.7.RELEASE\spring-boot-2.3.7.RELEASE.jar;
         * D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\org\springframework\boot\spring-boot-autoconfigure\2.3.7.RELEASE\spring-boot-autoconfigure-2.3.7.RELEASE.jar;
         * D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\org\springframework\boot\spring-boot-starter-logging\2.3.7.RELEASE\spring-boot-starter-logging-2.3.7.RELEASE.jar;
         * D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;
         * D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\org\apache\logging\log4j\log4j-to-slf4j\2.13.3\log4j-to-slf4j-2.13.3.jar;
         * D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\org\apache\logging\log4j\log4j-api\2.13.3\log4j-api-2.13.3.jar;D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\org\slf4j\jul-to-slf4j\1.7.30\jul-to-slf4j-1.7.30.jar;
         * D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\jakarta\annotation\jakarta.annotation-api\1.3.5\jakarta.annotation-api-1.3.5.jar;
         * D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\org\yaml\snakeyaml\1.26\snakeyaml-1.26.jar;D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\org\springframework\boot\spring-boot-starter-json\2.3.7.RELEASE\spring-boot-starter-json-2.3.7.RELEASE.jar;
         * D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\com\fasterxml\jackson\core\jackson-databind\2.11.3\jackson-databind-2.11.3.jar;
         * D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\com\fasterxml\jackson\core\jackson-annotations\2.11.3\jackson-annotations-2.11.3.jar;
         * D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\com\fasterxml\jackson\core\jackson-core\2.11.3\jackson-core-2.11.3.jar;D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\com\fasterxml\jackson\datatype\jackson-datatype-jdk8\2.11.3\jackson-datatype-jdk8-2.11.3.jar;D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\com\fasterxml\jackson\datatype\jackson-datatype-jsr310\2.11.3\jackson-datatype-jsr310-2.11.3.jar;D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\com\fasterxml\jackson\module\jackson-module-parameter-names\2.11.3\jackson-module-parameter-names-2.11.3.jar;D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\org\springframework\boot\spring-boot-starter-tomcat\2.3.7.RELEASE\spring-boot-starter-tomcat-2.3.7.RELEASE.jar;D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\org\apache\tomcat\embed\tomcat-embed-core\9.0.41\tomcat-embed-core-9.0.41.jar;D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\org\glassfish\jakarta.el\3.0.3\jakarta.el-3.0.3.jar;D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\org\apache\tomcat\embed\tomcat-embed-websocket\9.0.41\tomcat-embed-websocket-9.0.41.jar;D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\org\springframework\spring-web\5.2.12.RELEASE\spring-web-5.2.12.RELEASE.jar;D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\org\springframework\spring-beans\5.2.12.RELEASE\spring-beans-5.2.12.RELEASE.jar;D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\org\springframework\spring-webmvc\5.2.12.RELEASE\spring-webmvc-5.2.12.RELEASE.jar;D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\org\springframework\spring-aop\5.2.12.RELEASE\spring-aop-5.2.12.RELEASE.jar;D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\org\springframework\spring-context\5.2.12.RELEASE\spring-context-5.2.12.RELEASE.jar;D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\org\springframework\spring-expression\5.2.12.RELEASE\spring-expression-5.2.12.RELEASE.jar;D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\org\springframework\spring-core\5.2.12.RELEASE\spring-core-5.2.12.RELEASE.jar;D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\org\springframework\spring-jcl\5.2.12.RELEASE\spring-jcl-5.2.12.RELEASE.jar;D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\com\google\protobuf\protobuf-java\3.15.8\protobuf-java-3.15.8.jar;D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\log4j\log4j\1.2.17\log4j-1.2.17.jar;D:\apache-maven-3.1.0-bin\apache-maven-3.1.0\repository\org\slf4j\slf4j-api\1.7.25\slf4j-api-1.7.25.jar;D:\idea\IntelliJ IDEA 2019.3.3\lib\idea_rt.jar
         */
        //双亲委派机制:自己定义一个java.lang.String根本不会生效因为有双亲委派机制，
        // 双亲委派机制会查询跟加载器和扩展加载器，如果有重复的会使用根加载器或者扩展加载器中的类

    }
}
