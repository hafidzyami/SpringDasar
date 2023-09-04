package hafidz.demo;


public class Database {

    // singleton
    private static Database database;
    public static Database getInstance(){
        if(database == null){
            database = new Database();
        }
        return database;
    }
    private Database(){

    }
}
