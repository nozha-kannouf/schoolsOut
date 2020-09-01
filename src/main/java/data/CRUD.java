package data;

public interface CRUD<T> {
    void create(T t);
    T retrieve(T t);
    T update(T t);
    void delete(T t);
}
