
package dao;

import beans.Curso;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author meick
 */
public class CursoDAO {
    private Conexao conexao;
    private Connection conn;
    
    //Codigo Construtor
    public CursoDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void Inserir(Curso curso){
        String sql = "INSERT INTO curso (curso, classe_idclasse) VALUES " + "(?,?)";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, curso.getCurso());
            stmt.setString(2, curso.getClasse());
            stmt.execute();
        }catch(Exception e){
            System.out.println("Erro ao inserir curso "+ e.getMessage());
        }
        
    }
    
    public Curso getCurso(int idcurso){
        String sql = "SELECT * FROM curso WHERE idcurso = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idcurso);
            ResultSet rs = stmt.executeQuery();
            Curso curso = new Curso();
            rs.first();
            curso.setIdcurso(idcurso);
            curso.setCurso(rs.getString("curso"));
            return curso;
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar curso "+ e.getMessage());
            return null;
        }
    }
    
    public List<Curso> getCurso(String nomeCurso){
        String sql = "SELECT * FROM curso WHERE curso LIKE ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, "%" + nomeCurso + "&");
            ResultSet rs = stmt.executeQuery();
            List<Curso> listaCurso = new ArrayList<>();
            
            while(rs.next()){
                Curso curso = new Curso();
                curso.setIdcurso(rs.getInt("idcurso"));
                curso.setCurso(rs.getString("curso"));
                listaCurso.add(curso);
            }
            return listaCurso;
        } catch (Exception e) {
            System.out.println("Nenhum curso encontrado "+ e.getMessage());
            return null;
        }
    }
    
}
