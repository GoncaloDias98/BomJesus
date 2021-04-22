package backEnd;
import frontEnd.RegistarMissa;
import static frontEnd.Inicio.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Missa {
  private LocalDateTime horaInicio;
  private LocalDateTime horaFim;
  private String titulo;
  private String descricao;
  private int idMissa;

  public Missa(LocalDateTime horaInicio, LocalDateTime horaFim, String titulo, String descricao, int idMissa) {
    this.horaInicio = horaInicio;
    this.horaFim = horaFim;
    this.titulo = titulo;
    this.descricao = descricao;
    this.idMissa = idMissa;
  }

  public LocalDateTime getHoraInicio() {
    return horaInicio;
  }

  public void setHoraInicio(LocalDateTime horaInicio) {
    this.horaInicio = horaInicio;
  }

  public LocalDateTime getHoraFim() {
    return horaFim;
  }

  public void setHoraFim(LocalDateTime horaFim) {
    this.horaFim = horaFim;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public int getIdMissa() {
    return idMissa;
  }

  public void setIdMissa(int idMissa) {
    this.idMissa = idMissa;
  }


  public static void postDB() throws Exception{
    RegistarMissa missas = new RegistarMissa();
    String titulo = missas.titulotxt();
    try{
      Connection conn = getConnection();
      PreparedStatement posted = conn.prepareStatement("INSERT INTO missa (titulo) VALUES ('"+titulo+"')");
      posted.executeUpdate();
  } catch (Exception e){
      System.out.println(e);
    }
    finally {
      System.out.println(titulo);
      System.out.println("Insert into Missa Concluido");
    }
  }
  
  
}