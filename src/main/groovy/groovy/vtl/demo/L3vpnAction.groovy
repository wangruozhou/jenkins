package groovy.vtl.demo

import groovy.util.slurpersupport.GPathResult
import org.apache.velocity.Template
import org.apache.velocity.VelocityContext
import org.apache.velocity.app.VelocityEngine

class L3vpnAction {
    public static void main(String[] args){
        //获取传入的参数l3vpn
        XmlSlurper slurper = new XmlSlurper()
        GPathResult l3vpn = slurper.parse(new  File("src/main/resource/l3vpn.xml"))

        //获取velocity引擎
        VelocityEngine ve = new VelocityEngine()
        Template vtl = ve.getTemplate("src/main/resource/l3vpn.vm")
        VelocityContext ctx = new VelocityContext()

        Person p = new Person()
        p.name = "wwww"
        p.age = "100"
        print(l3vpn.'ctps')
        ctx.put("l3vpn",l3vpn)
        ctx.put("person",p)

        StringWriter sw = new StringWriter()
        vtl.merge(ctx,sw)
        print(sw)



    }
}

class Person{
    String name
    String age
}
