
package proizvod;
import java.sql.*;

public class Proizvod {

    public static void main(String[] args) {
        try{
            String dbURL = "jdbc:mysql://localhost:3306/prodaja";
            String user = "root";
            String pass = "";
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection veza = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("Uspesna konekcija");
            
            PreparedStatement ps = veza.prepareStatement("Insert into proizvod(SifraProizvoda, NazivProizvoda,ImeProizvodjaca) values(?, ?, ?)");
            
            ps.setString(1, new String("4"));
            ps.setString(2, new String("Penkalo"));
            ps.setString(3, new String("Stabilo"));
            try{
                ps.executeUpdate();
            }
            catch(SQLException sqle){
                System.out.println("Exception1: " + sqle.getMessage());
            }
            
            PreparedStatement ps2 = veza.prepareStatement("Delete from proizvod where NazivProizvoda =? ");
            ps2.setString(1, new String("Olovka"));
            try{
                ps2.executeUpdate();
            }
            catch(SQLException sqle){
                System.out.println("Exception2: " + sqle.getMessage());
            }
            
            PreparedStatement ps3 = veza.prepareStatement("Update proizvod set ImeProizvodjaca = 'Faber-Castell' where NazivProizvoda =? ");
            ps3.setString(1, new String("Gumica"));
            
            try{
                ps3.executeUpdate();
            }
            catch(SQLException sqle){
                System.out.println("Exception3: " + sqle.getMessage());
            }
            
            Statement stmt = veza.createStatement();
            ResultSet rezultat = stmt.executeQuery("select * from proizvod");
            
            
            
            System.out.println("Spisak proizvoda: ");
            while(rezultat.next()){
                String SifraProizvoda = rezultat.getString("SifraProizvoda");
                String NazivProizvoda = rezultat.getString("NazivProizvoda");
                String ImeProizvoda = rezultat.getString("ImeProizvodjaca");
                System.out.println(SifraProizvoda + " " + NazivProizvoda + " " + ImeProizvoda);
                
            }
            ps3.close();
            ps2.close();
            ps.close();
            ps.close();
            veza.close();
        }
        catch(ClassNotFoundException cnfe){
            System.out.println("Nije uspostavljena konekcija " + cnfe.getMessage());
        }
        catch(SQLException sqle){
            System.out.println("Exception: " + sqle.getMessage());
        }
    }
    
}
