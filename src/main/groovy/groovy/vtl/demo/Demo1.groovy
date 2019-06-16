package groovy.vtl.demo

import groovy.util.slurpersupport.GPathResult
import groovy.xml.MarkupBuilder

class Demo1 {
    public static void main(String[] args) {
        def xmlSlurper = new XmlSlurper()
        def file = new File("src/main/resource/test2.xml")
        def gpathResult = xmlSlurper.parse(file)

        //parse解析完之后，Persons就是根节点，不用再提现Persons这一级

        //打印所有的city值
        def cityList = gpathResult.person*.city
        println ( "打印所有city:\n" + cityList )
        //打印所有name
        def names = gpathResult.person*.@name
        println ( "打印所有name:\n" + names )

        //查找name是xiao5的节点，并打印link的rel值
        gpathResult.person.find {
            it ->
                if (it.@name == "xiao5") {
                    println it.link.@rel
                }

        }

        def st1 = new StringWriter()
        MarkupBuilder mb1 = new MarkupBuilder(st1);
        mb1.feed {
            entry(id: "1234567") {
                title {
                    show(name: "1234", "fdfsa")
                }
                link("ref": "http") {
                    url()
                }
            }
        }
        print st1
    }

}
