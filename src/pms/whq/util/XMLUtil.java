/*
 * XMLUtil.java
 *
 * Created on September 23, 2005, 3:56 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package pms.whq.util;

import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 *
 * @author psiegel
 */
public class XMLUtil {
  
  /** Creates a new instance of XMLUtil */
  private XMLUtil() {
  }
  
  public static String getAttribute(Node node, String name) {
    String value = "";
    
    NamedNodeMap attributes = node.getAttributes();
    Node attribute = attributes.getNamedItem(name);
    if (attribute != null) {
      value = attribute.getNodeValue();
    }
    
    return value;
  }
  
  public static String getText(Node node) {
    String value = "";
    
    NodeList children = node.getChildNodes();
    for (int k=0;k<children.getLength();k++) {
      Node child = children.item(k);
      if (child.getNodeType() == Node.TEXT_NODE) {
        value = child.getNodeValue();
      }
    }
    
    return value;
  }
  
  public static Node getNamedChild(Node node, String name) {
    Node retVal = null;
    
    NodeList children = node.getChildNodes();
    for (int i=0;i<children.getLength();i++) {
      Node child = children.item(i);
      if (child.getNodeName() == name) {
        retVal = child;
      }
    }
    
    return retVal;
  }    
  
  public static String getChildValue(Node node, String childName) {
    String value = "";

    Node child = getNamedChild(node, childName);
    if (child != null) {
      value = getText(child);
    }
    
    return value;
  }
  
  public static void addChildValue(Document doc, Node parent, String childName, 
                                   String childValue) {
    Element element = doc.createElement(childName);
    Text text = doc.createTextNode(childValue);
    element.appendChild(text);
    parent.appendChild(element);
  }
  
}
