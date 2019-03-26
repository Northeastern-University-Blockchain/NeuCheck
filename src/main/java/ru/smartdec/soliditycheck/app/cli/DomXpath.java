package ru.smartdec.soliditycheck.app.cli;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import ru.smartdec.soliditycheck.DocumentTreeBasic;
import ru.smartdec.soliditycheck.ParseTreeBasic;
import ru.smartdec.soliditycheck.SolidityParser;
import ru.smartdec.soliditycheck.SourceFile;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import java.nio.file.Paths;
import java.util.List;

public class DomXpath {
    public static void read3()throws Exception{
        try {
            long startTime=System.currentTimeMillis();

//            SAXReader reader = new SAXReader();
//            InputStream in = DomXpath.class.getClassLoader().getResourceAsStream("test.xml");
//            reader.getDocumentFactory().setXPathNamespaceURIs(map);
//            Document doc = reader.read(in);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource dOMSource = solidityToDom(new ArgumentsDefault("-s","tests_not_used_now\\file.sol"));
            Document document = (Document)dOMSource;



            String xpath ="//environmentalVariableDefinition";
            System.err.println("匹配规则：" + xpath);
            List<Element> list = document.selectNodes(xpath);
            for(Object o:list){
                Element e = (Element) o;
                String show=e.getStringValue();
                if(show.equals("block.timestamp")){
                    System.out.println("匹配内容：" + show);
                }
            }
            long endTime=System.currentTimeMillis();
            System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)throws Exception{
        read3();
        //TreeFactory trees = solidityToTrees(new ArgumentsDefault("-s","tests_not_used_now\\file.sol"));
        /*TransformerFactory tff = TransformerFactory.newInstance();
        Transformer tf = tff.newTransformer();
        tf.transform(dOMSource, new StreamResult("F:/666.xml"));*/
    }
    public static DOMSource solidityToDom(Arguments arguments) throws Exception{
        return new DOMSource(
                new DocumentTreeBasic(
                        new ParseTreeBasic(new SourceFile(arguments
                                .value("-s", "-source")
                                .map(Paths::get)
                                .orElseThrow(IllegalArgumentException::new))),
                        DocumentBuilderFactory
                                .newInstance()
                                .newDocumentBuilder(),
                        SolidityParser.ruleNames
                )
                        .info()
                        .node()
        );
    }

}