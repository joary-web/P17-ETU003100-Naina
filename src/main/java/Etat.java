import java.lang.*;
import java.util.*;
import java.sql.*;
import java.lang.reflect.*;

public class Etat extends Genericclass{
    public String libelle="";
    public int somme=0;
    public int reste=0;
    
    public Etat(String libelle, int somme, int reste){
        this.libelle=libelle;
        this.somme=somme;
        this.reste=reste;
    }

    public String get_libelle(){
        return this.libelle;
    }
    public int get_somme(){
        return this.somme;
    }
    public int get_reste(){
        return this.reste;
    }
    public void set_libelle(String libelle){
        this.libelle=libelle;
    }
    public void set_somme(int somme){
        this.somme=somme;
    }
    public void set_reste(int reste){
        this.reste=reste;
    }
    public List<BaseobjectOO> findall(){
        Class t=this.getClass();
        Field[] fl=t.getFields();
        String sql="select sum(d.depense) somme,sum(d.depense)-p.montant from depense d join prevision p on d.libelle=p.libelle";
        String nomm="set_";
        List<BaseobjectOO> l=new ArrayList<>();
        Statement state=null;
        Connection con=null;
        try{
        Utildb udb=new Utildb();
        con=udb.ConnectToDb();
        state=con.createStatement();
        ResultSet res=state.executeQuery(sql);
        int i=0;
            while(res.next()) {
                int j=0;
                Etat ob=new Etat();
                while(j<res.getMetaData().getColumnCount()){
                    Class<?>[] type={fl[j].getType()}; 
                    Method md=t.getDeclaredMethod(nomm+fl[j].getName(),type);
                    md.invoke(ob,res.getObject(j));
                    j++;
                }
                l.add(ob);
                i++;
            }
            
        } catch (Exception e) {
        }finally{
            state.close();
            con.close();
        }
        return l;
    }
}