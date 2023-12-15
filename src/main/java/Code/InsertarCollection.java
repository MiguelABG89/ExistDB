package Code;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;

import java.io.File;

public class InsertarCollection {
    private static final String DRIVER = "org.exist.xmldb.DatabaseImpl";
    private static final String URI = "xmldb:exist://localhost:8443/exist/xmlrpc/db";
    private static final String USER = "admin";
    private static final String PASSWORD = "";

    private static Collection collection;

    public static void Insertar() {

        File XmlFamilia = new File("src/main/resources/familias.xml");
        File XmlProyectos = new File("src/main/resources/proyectosFP.xml");
        Centros centros = new Centros();
        try {

            // Cargar el controlador
            Class cl = Class.forName(DRIVER);
            Database database = (Database) cl.newInstance();
            DatabaseManager.registerDatabase(database);

            // Establecer la conexión
            collection = DatabaseManager.getCollection(URI, USER, PASSWORD);
            if (collection==null){
                System.out.println("conexion erronea");
            }else {
                System.out.println("Exito de conexion");
                if (!XmlFamilia.canRead()){
                    System.out.println("Error al intentar leer el documento Familias");
                }else {
                    Resource resource = collection.createResource(XmlFamilia.getName(),"XMLResource");
                    resource.setContent(XmlFamilia);
                    collection.storeResource(resource);
                }
                if (!XmlProyectos.canRead()){
                    System.out.println("Error al intentar leer el documento Familias");
                }else {
                    Resource resource = collection.createResource(XmlProyectos.getName(),"XMLResource");
                    resource.setContent(XmlProyectos);
                    collection.storeResource(resource);
                }
            }
            collection.close();
        } catch (Exception e) {
            System.out.println("Error en la conexión de la base de datos eXistDB");
            e.printStackTrace();
        }
    }
}
