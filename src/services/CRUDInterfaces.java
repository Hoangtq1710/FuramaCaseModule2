package services;

import java.util.List;

public interface CRUDInterfaces<T>{
    List<T> findAll();
    void add(T t);
}
