
package prodaja;

import java.sql.*;

public class Prodaja {

    public static void main(String[] args) {
        try{
            String dbURL = "jdbc:mysql://localhost:3306/prodaja";
            String user = "root";
            String pass = "";
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection veza = DriverManager.getConnection(dbURL,user,pass);
            System.out.println("Uspesno uspostavljena konekcija");
            
            Statement stmt = veza.createStatement();
            
            ResultSet rezultat = stmt.executeQuery("select * from racun");
            System.out.println("Racuni: ");
            while(rezultat.next()){
                String BrojRacuna = rezultat.getString("BrojRacuna");
                String NazivPartnera = rezultat.getString("NazivPartnera");
                String UkupnaVrednost = rezultat.getString("UkupnaVrednost");
                Boolean Obradjen = rezultat.getBoolean("Obradjen");
                Boolean Storniran = rezultat.getBoolean("Storniran");
                System.out.println(BrojRacuna + " " + UkupnaVrednost + " " + 
                        NazivPartnera  + " " +  Obradjen + " " + Storniran);
                
            }
        }
        catch(ClassNotFoundException cnfe){
            System.out.println("Upravljacki program nije ucitan " + cnfe.getMessage());
        }
        catch(SQLException sqle){
            System.out.println("Exception " + sqle.getMessage());
    }
    
    }
}
