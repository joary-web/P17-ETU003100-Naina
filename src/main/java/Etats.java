import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Etats extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();
        Etat e=new Etat();
        List<Etat> liste=e.findall();
        req.setParameter("liste",liste);
        RequestDispatcher dispatch=req.getDispatcher("/formemp.html");
        dispatch.forward(req,res);
    }
}