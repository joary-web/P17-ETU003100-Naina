import java.sql.*;
import java.util.*;
import java.lang.*;

public class Depense extends Genericclass{
    public String libelle="";
    public int depense=0;
    
    public Depense(int id,String libelle, int depense){
        this.libelle=libelle;
        this.depense=depense;
    }

    public int get_id(){
        return this.id;
    }
    public String get_libelle(){
        return this.libelle;
    }
    public int get_depense(){
        return this.depense;
    }
    public void set_id(int id){
        this.id=id;
    }
    public void set_libelle(String libelle){
        this.libelle=libelle;
    }
    public void set_depense(int depense){
        this.id=depense;
    }

}