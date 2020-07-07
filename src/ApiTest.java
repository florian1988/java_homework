import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;

public class ApiTest {

    // API Key: 989a74655007f95dc6af51726d73a8d0

        public static void main(String[] args) throws Exception{

            String uri = "http://api.openweathermap.org/data/2.5/forecast?q=Vienna&mode=xml&appid=989a74655007f95dc6af51726d73a8d0";
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            Document document =  factory.newDocumentBuilder().parse(uri);

            NodeList times = document.getElementsByTagName("time");


            //System.out.println(document.getDocumentElement().getTagName());
            //System.out.println(times.getLength());

            for( int i = 0; i < times.getLength(); i++){
                Node time = times.item(i);
                NamedNodeMap timeAttributes = time.getAttributes();

                String timestamp = timeAttributes.getNamedItem("from").getNodeValue();

                NodeList children = time.getChildNodes();

                System.out.println();

                for(int y = 0; y < children.getLength(); y++){
                    Node child = children.item(y);
                    //System.out.println(child.getNodeName());

                    if (child.getNodeName() == "temperature"){
                        String temperature = child.getAttributes().getNamedItem("value").getNodeValue();
                        Float number = Float.parseFloat(temperature);
                        float now = number - 271;
                        System.out.println(timestamp + ": Celsius: " + now);
                    }

                    if(child.getNodeName() == "clouds"){
                        String cloud = child.getAttributes().getNamedItem("value").getNodeValue();

                        System.out.println("sky: " + cloud);
                    }


                }

            }

        }

    }


