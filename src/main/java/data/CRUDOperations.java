package data;

public interface CRUDOperations<T> {
    void create(T t);
    T retrieve(T t);
    T update(T t);
    void delete(T t);
}
