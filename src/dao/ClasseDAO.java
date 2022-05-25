/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Classe;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author meick
 */
public class ClasseDAO {
    private Conexao conexao;
    private Connection conn;
    
    public ClasseDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void Inserir(Classe classe){
        String sql = "INSERT INTO classe (classe, sala_idsala) VALUES " + "(?,?)";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, classe.getClasse());
            stmt.setString(2, classe.getSala());
            stmt.execute();
        }catch(Exception e){
            System.out.println("Erro ao inserir classe "+ e.getMessage());
        }
    }
}
