package model;

public class Candidate {

    private int id;
    private String candidato;
    private int votos;
    private String foto;

    public Candidate() {
    }

    public Candidate(int id, String candidato, int votos, String foto) {
        this.id = id;
        this.candidato = candidato;
        this.votos = votos;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCandidato() {
        return candidato;
    }

    public void setCandidato(String candidato) {
        this.candidato = candidato;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
