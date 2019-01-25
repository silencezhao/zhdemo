package priv.zh;

import priv.zh.model.HelloWorld;
import priv.zh.model.HelloWorldService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.sf.jasperreports.engine.JasperCompileManager;
/*
@author SilenceZhao
@propose exer Spring
*/

public class App  
{
    public static void main( String[] args ) throws Exception
    {
        /*
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        HelloWorldService service=(HelloWorldService)context.getBean("helloWorldService");
        HelloWorld helloWorld=service.getHelloWorld();
        helloWorld.sayHello();
        */
        JasperCompileManager.compileReportToFile("/media/heng/SilenceZhao/code/java/zhdemo/demo1/target/classes/PISA_SJBL.jrxml", "/media/heng/SilenceZhao/code/java/zhdemo/demo1/target/classes/PISA_SJBL.jasper");
        System.out.println("ok");
    }
}