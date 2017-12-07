package xmlOperations.CreateXML;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Observer
{
	static String					inputFile			= "C:\\Users\\Admin\\Desktop\\XML\\inputData.txt";
	static String					outputXMLPath		= "C:\\Users\\Admin\\Desktop\\XML\\file.xml";

	// GlobalDetails
	static DocumentBuilderFactory	docFactory			= DocumentBuilderFactory.newInstance();
	static DocumentBuilder			docBuilder			= null;
	static Document					doc					= null;
	static Element					domainsElement		= null;

	static Map<String, Element>		domainObjTracker	= new TreeMap<String, Element>();

	static void CreateXML(String[] splitStr)
	{
		// domain
		Element domainElement = null;
		if(domainObjTracker.containsKey(splitStr[0]))
		{
			// fetch
			domainElement = (Element) domainObjTracker.get(splitStr[0]);
		}
		else
		{
			// Create new obj
			domainElement = doc.createElement("domain");
			domainsElement.appendChild(domainElement);

			domainObjTracker.put(splitStr[0], domainElement);
		}

		// Set attribute of domain
		Attr attr = doc.createAttribute("name");
		attr.setValue(splitStr[0]);
		domainElement.setAttributeNode(attr);

		// rule ID
		Element oneRuleElement = doc.createElement("rule");
		domainElement.appendChild(oneRuleElement);

		// Inside Rule
		// PathRule ID
		Element onepathRuleElement = doc.createElement("pathRule");
		onepathRuleElement.appendChild(doc.createTextNode(splitStr[1])); // write
		oneRuleElement.appendChild(onepathRuleElement);

		// Variation
		Element oneVariationElement = doc.createElement("variation");
		oneVariationElement.appendChild(doc.createTextNode(splitStr[2])); // write
		oneRuleElement.appendChild(oneVariationElement);

		// Response
		Element oneResponseElement = doc.createElement("response");
		oneResponseElement.appendChild(doc.createTextNode(splitStr[3])); // write
		oneRuleElement.appendChild(oneResponseElement);

	}

	public static void main(String argv[]) throws IOException
	{

		try
		{

			// "C:\\Users\\sugyan\\Desktop\\testfile_100.txt"

			docBuilder = docFactory.newDocumentBuilder();

			doc = docBuilder.newDocument();

			// root
			domainsElement = doc.createElement("domains");
			doc.appendChild(domainsElement);

			BufferedReader br = new BufferedReader(new FileReader(new File(inputFile)));
			String line;

			while ((line = br.readLine()) != null)
			{
				String[] splitStr = line.split("\t");

				CreateXML(splitStr);
			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(outputXMLPath));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File saved!");

		}
		catch(ParserConfigurationException pce)
		{
			pce.printStackTrace();
		}
		catch(TransformerException tfe)
		{
			tfe.printStackTrace();
		}
	}
}