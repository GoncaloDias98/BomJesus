package backEnd;

import java.time.LocalDateTime;

public class Evento {

  private LocalDateTime horaInicio;
  private LocalDateTime horaFim;
  private String titulo;
  private String descricao;
  private int idEvento;

  public Evento(LocalDateTime horaInicio, LocalDateTime horaFim, String titulo, String descricao, int idEvento) {
    this.horaInicio = horaInicio;
    this.horaFim = horaFim;
    this.titulo = titulo;
    this.descricao = descricao;
    this.idEvento = idEvento;
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

  public int getIdEvento() {
    return idEvento;
  }

  public void setIdEvento(int idEvento) {
    this.idEvento = idEvento;
  }
}