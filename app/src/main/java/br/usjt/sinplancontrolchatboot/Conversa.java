package br.usjt.sinplancontrolchatboot;

/**
 * Created by supor on 29/03/2018.
 */

public class Conversa{
    private String usuario;
    private String pergunta;
    private String resposta;

    public Conversa(String usuario, String pergunta, String resposta) {
        this.usuario = usuario;
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    public Conversa() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
