import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Formdep extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();
        String libelle=req.getParameter("libelle");
        String Depense=req.getParameter("Depense");
        Depense Depense=new Depense(libelle,Depense);
        Depense.save();
        RequestDispatcher dispatch=req.getDispatcher("/Depense.jsp");
        dispatch.forward(req,res);
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();
        Depense depense=new Depense();
        List<Depense> depenses = Depense.findall();
        req.setParameter("depts",depenses);
        RequestDispatcher dispatch=req.getDispatcher("/Depense.jsp");
        dispatch.forward(req,res);
    }
}