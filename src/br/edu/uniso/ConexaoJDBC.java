package br.edu.uniso;

import java.sql.*;

public class ConexaoJDBC {
    public static void main (String args[]){

        /* Tratar possíveis problemas */
        try {
            /*DriverMenager comanda as conexões*/
            /*Definir conexao*/
            Connection c =  DriverManager.getConnection("jdbc:mysql://34.225.155.37:3306/luis_assuncao",
                    "luis_assuncao", "2610200308");

            /*Validar a conexao*/
            boolean valido = c.isValid(1000);
            System.out.println("conexao eh valida: "+ valido);

            Statement s = c.createStatement();
            /*Executar um select*/
            ResultSet rs = s.executeQuery("select * from ALUNO");
            while(rs.next()){
                System.out.println("RA: "+ rs.getInt("ra"));
                System.out.println("Nome: "+rs.getString("primeiro_nome"));
                System.out.println("Sobrenome: "+rs.getString("sobrenome"));
                System.out.println("Idade: "+rs.getInt("idade"));
            }

            /*Inserir dados
            Statement i = c.createStatement();
            i.executeUpdate("insert into ALUNO(ra, primeiro_nome, sobrenome, idade) values " +
                    "(99147, 'Luis', 'Assuncao', 19)");

            /*Fechar processos para otimizar memória*/
            rs.close();
            s.close();
            c.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
