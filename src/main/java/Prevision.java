import java.sql.*;
import java.util.*;
import java.lang.*;

public class Prevision extends Genericclass{
    public String libelle="";
    public int montant=0;
    
    public Prevision(int id,String libelle, int montant){
        this.id=id;
        this.libelle=libelle;
        this.montant=montant;
    }

    public int get_id(){
        return this.id;
    }
    public String get_libelle(){
        return this.libelle;
    }
    public int get_montant(){
        return this.montant;
    }
    public void set_id(int id){
        this.id=id;
    }
    public void set_libelle(String libelle){
        this.libelle=libelle;
    }
    public void set_montant(int montant){
        this.id=montant;
    }
}