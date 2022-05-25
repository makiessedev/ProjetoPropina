/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Classe;
import beans.Sala;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author meick
 */
public class SalaDAO {
    private Conexao conexao;
    private Connection conn;
    
    public SalaDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    
    }
    public void Inserir(Sala sala){
        String sql = "INSERT INTO sala (sala) VALUES " + "(?)";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, sala.getSala());
            stmt.execute();
        }catch(Exception e){
            System.out.println("Erro ao inserir sala "+ e.getMessage());
        }
    }
}
