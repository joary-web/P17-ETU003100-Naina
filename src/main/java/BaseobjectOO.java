public abstract class BaseobjectOO {
    public int id;

    public int getid(){
        return this.id=id;
    }

    public void setid(int id){
        this.id=id;
    }

    public abstract void save();
    public abstract void findall();
    public abstract void findid();
    public abstract void findpage();
}
