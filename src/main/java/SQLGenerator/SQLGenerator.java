package SQLGenerator;


import Entity.Entity;

public interface SQLGenerator<T extends Entity> {
    String insert (T toInsert);
    String createTable();
}
