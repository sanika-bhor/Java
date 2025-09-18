import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
public class logindemo extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException , IOException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String name=req.getParameter("tf1");
        pw.print("<html>");
        pw.print("<body>");
        pw.print("<h1><i>welcome "+name+"</i></h1>");
        pw.print("</body>");
        pw.print("</html>");
        pw.close();
    }
}