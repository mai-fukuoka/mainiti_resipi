package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
    /**  JPAユニット名. */
    private static final String PERSISTENCE_UNIT_NAME = "file_upload_system";

    private static EntityManagerFactory emf;


    /**
     * EntityManagerを生成するメソッド.
     * @return EntityManager
     */
    public static EntityManager createEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    /**
     * EntityManagerFactoryを生成するメソッド.
     * @return EntityManagerFactory
     */
    private static EntityManagerFactory getEntityManagerFactory() {

        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        return emf;
    }
}