import java.lang.*;
import java.sql.*;
import java.util.*;
import java.lang.reflect.*;

public class Genericclass extends BaseobjectOO{
    
    @Override
    public void save(){
        Connection con=null;
        Statement state=null;
        Class t=this.getClass(); 
        Field[] tab=t.getFields();
        String sql="insert into "+this.getClass().getName()+" value(";
        String sep="";
        String nomm="get_";
        try{
        Utildb udb=new Utildb();
        con=udb.ConnectToDb();
        state=con.createStatement();
        for(int a=0;a<tab.length;a++){
            sep=",";
            if(a==0){sep="";}
            if(tab[a].getName()=="int"){ 
                    Method md=t.getDeclaredMethod(nomm+tab[a].getName());
                sql=sql+sep+md.invoke(this).toString();
            } else {
                    Method md=t.getDeclaredMethod(nomm+tab[a].getName());
            sql=sql+sep+"'"+md.invoke(this).toString()+"'";
            }
        }
        sql=sql+")";
        ResultSet res=state.executeQuery(sql);
        state.close();
        con.close();
        } catch(Exception e){
    System.out.println(e);
    }
    }

    @Override
    public List<BaseobjectOO> findall(){
        Class t=this.getClass();
        Field[] fl=t.getFields();
        String sql="select * from "+t.getName();
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
                BaseobjectOO ob=new BaseobjectOO();
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
    @Override
    public BaseobjectOO findid(int id,String nom){
        BaseobjectOO ob=new BaseobjectOO();
        Class t=Class.forName("nom");
        Field[] fl=t.getFields();
        String sql="select * from "+nom+" where id="+id;
        String nomm="set_";
        Connection con=null;
        Statement state=null;
        try{
        Utildb udb=new Utildb();
        con=udb.ConnectToDb();
        state=con.createStatement();
        ResultSet res=state.executeQuery(sql);
        int i=0;
            while(res.next()) {
                int j=0;
                while(j<res.getMetaData().getColumnCount()){
                    Class<?>[] type={fl[j].getType()}; 
                    Method md=t.getDeclaredMethod(nomm+fl[j].getName(),type);
                    md.invoke(ob,res.getObject(j));
                    j++;
                }
                i++;
            }
        } catch (Exception e) {
        }finally{
            state.close();
            con.close();
        }
        return ob;
    }
    
    @Override
    public List<BaseobjectOO> findpage(int in,int nb, String nom){
        Utildb udb=new Utildb();
        Class t=Class.forName("nom");
        Field[] fl=t.getFields();
        String sql="select * from "+nom+"limit "+nb+","+in;
        String nomm="set_";
        List<BaseobjectOO> l=new ArrayList<>();
        Connection con=null;
        Statement state=null;
        try{
        con=udb.ConnectToDb();
        state=con.createStatement();
        ResultSet res=state.executeQuery(sql);
        int i=0;
            while(res.next()) {
                int j=0;
                BaseobjectOO ob=new BaseobjectOO();
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


