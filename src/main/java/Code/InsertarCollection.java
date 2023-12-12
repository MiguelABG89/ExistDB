package Code;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;

import java.nio.file.Path;
import java.sql.Connection;

public class InsertarCollection {
    private static final String DRIVER = "org.exist.xmldb.DatabaseImpl";
    private static final String URI = "xmldb:exist://localhost:8080/exist/xmlrpc";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    private static Collection collection;

    public static void Insertar() {
        Path XmlFamilia = Path.of("src/main/resources/familias.xml");
        Path XmlProyectos = Path.of("src/main/resources/proyectosFP.xml");

        try {
            // Cargar el controlador
            Class cl = Class.forName(DRIVER);
            Database database = (Database) cl.newInstance();
            DatabaseManager.registerDatabase(database);

            // Establecer la conexión
            collection = DatabaseManager.getCollection(URI, USER, PASSWORD);

        } catch (Exception e) {
            System.out.println("Error en la conexión de la base de datos eXistDB");
            e.printStackTrace();
        }
    }
}
