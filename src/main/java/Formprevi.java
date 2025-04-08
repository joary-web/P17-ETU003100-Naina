import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Formprevi extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();
        String libelle=req.getParameter("libelle");
        String montant=req.getParameter("montant");
        Prevision dept=new Prevision(libelle,montant);
        dept.save();
        RequestDispatcher dispatch=req.getDispatcher("/Prevision.jsp");
        dispatch.forward(req,res);
    }
    
}