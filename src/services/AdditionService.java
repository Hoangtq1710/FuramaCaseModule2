package services;

import java.util.List;

public interface AdditionService<T> extends CRUDInterfaces<T>{
    List<T> sortById();
}
