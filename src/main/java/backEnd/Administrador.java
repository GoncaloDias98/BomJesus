package backEnd;

public class Administrador {
  private String username;
  private String password;
  private String nome;
  private String contacto;
  private String email;

  public Administrador (String username, String password, String nome, String contacto, String email){
    this.username = username;
    this.password =password;
    this.nome = nome;
    this.contacto = contacto;
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getNome() {
    return nome;
  }

  public String getContacto() {
    return contacto;
  }

  public String getEmail() {
    return email;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setContacto(String contacto) {
    this.contacto = contacto;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
