package ru.tikhonovaf.samples.patterns.structural.adapter;

interface JsonData {
    String getJson();
}

class XmlData {
    private final String xml;
    public XmlData(String xml) { this.xml = xml; }
    public String getXml() { return xml; }
}

class XmlToJsonAdapter implements JsonData {
    private final XmlData xmlData;

    public XmlToJsonAdapter(XmlData xmlData) {
        this.xmlData = xmlData;
    }

    @Override
    public String getJson() {
        // Упрощённая конвертация
        return "{ \"converted\": \"" + xmlData.getXml() + "\" }";
    }
}

public class AdapterDemo {
    public static void main(String[] args) {
        XmlData xml = new XmlData("<tag>Hello</tag>");
        System.out.println(xml.getXml());

        JsonData adapted = new XmlToJsonAdapter(xml);

        System.out.println(adapted.getJson());
    }
}
