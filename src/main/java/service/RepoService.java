package service;

import java.util.List;

public interface RepoService {
    public String insert(String document);
    public String remove(String id);
    public String update(String id, List<Filter> query);
    public List<String> getAll();
    public String get(List<Filter> query);
    public void clearDB();
}
