package service;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    public String key;
    public String value;
    private List<Filter> list = new ArrayList<>();

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Filter> getList() {
        return list;
    }

    public void add(String key, String value) {
        Filter filter = new Filter();
        filter.key = key;
        filter.value = value;
        list.add(filter);
    }
}
