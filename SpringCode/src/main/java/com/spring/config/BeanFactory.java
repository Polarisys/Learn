package com.spring.config;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @anthor Tolaris
 * @date 2020/8/21 - 14:01
 */
public class BeanFactory {

    private Map<String, Object> map = new HashMap<String, Object>();

    public BeanFactory(String xml) {
        parseXml(xml);
    }

    public void parseXml(String xml) {

        File file = new File(this.getClass().getResource("/").getPath() +
                "//" + xml);
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(file);
            Element rootElement = document.getRootElement();
            for (Iterator<Element> it = rootElement.elementIterator(); it.hasNext(); ) {
                Element element = it.next();
                Attribute id = element.attribute("id");
                String beanName = id.getValue();
                Attribute aClass = element.attribute("class");
                String beanClass = aClass.getValue();
                Class clazz = Class.forName(beanClass);
                Object object = clazz.newInstance();

                for (Iterator<Element> itSecond =
                     element.elementIterator(); itSecond.hasNext(); ) {
                    Element element1 = itSecond.next();
                    if (element1.getName().equals("property")) {
                        String name = element1.attribute("name").getValue();
                        String ref = element1.attribute("ref").getValue();
                        Object injectObject = map.get(ref);
                        Field field = clazz.getDeclaredField(name);
                        field.setAccessible(true);
                        field.set(object,injectObject);
                    }
                }

                map.put(beanName, object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public Object getBean(String name) {
        return map.get(name);
    }
}
