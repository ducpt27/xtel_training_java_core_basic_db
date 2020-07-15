package ptd.java_core.basic.exercise.db.b4_student_manager.config;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import java.io.*;

public abstract class AbsConfig {

    public String pathFile;
    protected DocumentBuilderFactory dBFactory;
    protected DocumentBuilder dBuilder;
    protected Document doc;
    protected NodeList nodeList;
    protected Node node;
    protected Element element;

    public AbsConfig(String pathFile) {
        this.pathFile = pathFile;
    }

    protected void execute() throws Exception {
        File inputFile = new File(pathFile);
        dBFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dBFactory.newDocumentBuilder();
        doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        loadConfig();
        System.out.println(doc);
    }

    protected String getString(String nodeUrl, String defaultValue) throws Exception {
        if (nodeUrl == null || nodeUrl.isEmpty()) {
            return defaultValue;
        }

        String[] var1 = nodeUrl.split("\\.");
        if (var1.length < 2) {
            nodeList = doc.getElementsByTagName(nodeUrl);
            node = nodeList.item(0);
            element = (Element) node;
            String var6 = element.getTextContent();
            if (var6 == null || var6.isEmpty()) {
                return defaultValue;
            }
            return var6;
        }
        element = doc.getDocumentElement();

        for (int i = 0; i < var1.length - 1; i++) {
            String[] var2 = var1[0].split("\\[");
            String var3 = var2[0];
            int var4 = Integer.parseInt(var2[1].replace("]", ""));
            element = (Element) element.getElementsByTagName(var3).item(var4);
        }

        String var5 = element.getElementsByTagName(var1[var1.length - 1]).item(0).getTextContent();
        if (var5 == null || var5.isEmpty()) {
            return defaultValue;
        }

        return var5;
    }

    protected int getInt(String nodeUrl, int defaultValue) throws Exception {
        if (getString(nodeUrl, null) == null) {
            return defaultValue;
        }
        return Integer.parseInt(getString(nodeUrl, null));
    }

    protected double getDouble(String nodeUrl, double defaultValue) throws Exception {
        if (getString(nodeUrl, null) == null) {
            return defaultValue;
        }
        return Double.parseDouble(getString(nodeUrl, null));
    }

    protected float getFloat(String nodeUrl, float defaultValue) throws Exception {
        if (getString(nodeUrl, null) == null) {
            return defaultValue;
        }
        return Float.parseFloat(getString(nodeUrl, null));
    }

    protected long getLong(String nodeUrl, long defaultValue) throws Exception {
        if (getString(nodeUrl, null) == null) {
            return defaultValue;
        }
        return Long.parseLong(getString(nodeUrl, null));
    }

    protected abstract void loadConfig() throws Exception;
}
