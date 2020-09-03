package data;

import java.util.Optional;

public interface CRUDOperations<T> {
    Optional<T> create(T t);
    Optional<T> retrieve(Object identity);
    T update(T t);
    boolean delete(T t);
}
