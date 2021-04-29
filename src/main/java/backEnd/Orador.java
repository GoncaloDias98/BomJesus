package backEnd;

import static frontEnd.Inicio.getConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Orador {
  private String nome;
  private String cargo;

  public Orador(String nome, String cargo) {
    this.nome = nome;
    this.cargo = cargo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }


}

