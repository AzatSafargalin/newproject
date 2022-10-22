package ru.ilb.newproject.converters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author AndrewSych
 */
public class XmlIntegerAdapter extends XmlAdapter<String, Integer> {

    @Override
    public String marshal(Integer value) throws Exception {
        if (value == null) {
            return null;
        }

        return value.toString();
    }

    @Override
    public Integer unmarshal(String storedValue) throws Exception {
        if (storedValue.equalsIgnoreCase("")) {
            return null;
        }

        return Integer.valueOf(storedValue);
    }
}
