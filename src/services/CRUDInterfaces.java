package services;

import java.util.List;

public interface CRUDInterfaces<T>{
    List<T> findAll();
    T findById(int id);
    void add(T t);
    void edit(T t, int id);
    void remove(int id);
    boolean idExist(int id);

}
