
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author meick
 */
public class Conexao {
    
    public Connection getConexao(){
        try{
            //Aqui tenta conectar ao banco de dados
            Connection conn = DriverManager.getConnection(
             "jdbc:mysql://localhost:3306/propina?serverTimezone=UTC",//Linha de comando
             "root",//Usuario do mysql
             "palavrap"//Senha do mysql
                    
            );
            return conn;
        }catch(Exception e){
            //Aqui aparece os erros
            System.out.println("Erro ao conectar "+e.getMessage());
            return null;
        }
    }
    
}
