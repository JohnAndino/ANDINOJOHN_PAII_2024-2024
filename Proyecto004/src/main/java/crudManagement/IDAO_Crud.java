package crudManagement;

public interface IDAO_Crud<T> {
	void create(T entity);

	T read(int id);

	void update(T entity);

	void delete(T entity);
}
