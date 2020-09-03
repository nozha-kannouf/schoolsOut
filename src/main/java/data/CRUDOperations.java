package data;

import java.util.Optional;

public interface CRUDOperations<T> {
    void create(T t);
    Optional<T> retrieve(T t);
    T update(T t);
    void delete(T t);
}
