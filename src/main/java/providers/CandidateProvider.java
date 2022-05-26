package providers;

import db.DbConnection;
import model.Candidate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CandidateProvider {

    public void create(Candidate candidate) throws SQLException {
        System.out.println(candidate.getCandidato());
        System.out.println(candidate.getVotos());
        System.out.println(candidate.getFoto());
        System.out.println(candidate.getId());

        String sql = ("INSERT INTO votaciones(candidato,votos,foto) VALUES ('$CANDIDATO',$VOTOS,'$FOTO')")
                .replace("$CANDIDATO", candidate.getCandidato())
                .replace("$VOTOS",""+candidate.getVotos())
                .replace("$FOTO", candidate.getFoto());
        DbConnection connection = new DbConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public Candidate candidate(int idp) throws SQLException {

        Candidate candidate=new Candidate();
        String sql = "SELECT * FROM votaciones";
        DbConnection connection =  new DbConnection();
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(sql);

        while(resultSet.next()){


            int id = resultSet.getInt(resultSet.findColumn("id"));
            String candidato = resultSet.getString(resultSet.findColumn("candidato"));
            int votos = resultSet.getInt(resultSet.findColumn("votos"));
            String foto = resultSet.getString(resultSet.findColumn("foto"));

            if(idp == id){

                candidate.setId(id);
                candidate.setCandidato(candidato);
                candidate.setVotos(votos);
                candidate.setFoto(foto);
            }
        }

        connection.disconnect();
        return candidate;
    }



    public void add1Vote(Candidate candidate )  throws SQLException {
        String sql = ("UPDATE candidatos=$CANDIDATOS SET votos= $VOTOS WHERE id=$ID");

        int votos = candidate.getVotos() + 1;
        candidate.setVotos(votos);
        sql = sql.replace("$ID", "" + candidate.getId());
        sql = sql.replace("$VOTOS", "" + candidate.getVotos());

        DbConnection connection = new DbConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }




    public ArrayList<Candidate> getAllCandidate() throws SQLException {

        ArrayList<Candidate> output = new ArrayList<>();
        String sql = "SELECT * FROM votaciones";
        DbConnection connection =  new DbConnection();
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(sql);

        while(resultSet.next()){


            int id = resultSet.getInt(resultSet.findColumn("id"));
            String candidato = resultSet.getString(resultSet.findColumn("candidato"));
            int votos = resultSet.getInt(resultSet.findColumn("votos"));
            String foto = resultSet.getString(resultSet.findColumn("foto"));
            Candidate candidate = new Candidate(id,candidato,votos,foto);
            output.add(candidate);
        }

        connection.disconnect();
        return output;
    }
}
