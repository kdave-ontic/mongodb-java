package repository;

import service.Filter;

import java.util.List;

public interface RepositoryService {

    <T> T save(T object);

    <T> List<T> get(List<Filter> filters);

    Class<?> getAnnotationClass();

}