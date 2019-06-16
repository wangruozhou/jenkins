package dom4jDemos;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class ParseDom {
    public static void main(String[] args) throws DocumentException {
        demo1();
    }
    public static void demo1() throws DocumentException {
        //使用dom4j读取file,并解析
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File("src/main/resource/demo1.xml"));
        Node ifNode = doc.selectSingleNode("//interface");
        Element ele = (Element)ifNode;
        List<Node> ifNames = ifNode.selectNodes("ifName");
        Node sap = ifNode.selectSingleNode("//sap");
        System.out.println(sap.getText());
        for(Node ifName:ifNames){
            System.out.println(ifName.getText());
        }
//        System.out.println(ifName.valueOf("@operation"));
//        System.out.print(ifName.getText());
    }
}
