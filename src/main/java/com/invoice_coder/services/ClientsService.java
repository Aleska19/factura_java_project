package com.invoice_coder.services;

import com.invoice_coder.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ClientsService {
    @Autowired
    private  JdbcTemplate jdbc;

    public ClientsService(JdbcTemplate jdbc){
        this.jdbc = jdbc;

    }

    public void saveClient(Clients clients){
        this.jdbc.update(
                "INSERT INTO Clients (name, lastname, docnumber) VALUES (?,?,?)",
                clients.getName(),
                clients.getLastname(),
                clients.getDocnumber()
        );
    }

                //Lista de clientes//

    public List<Clients> getClients(){
        return this.jdbc.query(
                "SELECT * FROM Clients",
                (rs, rowNum) -> new Clients(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("lastname"),
                        rs.getString("docnumber")


                )
        );

    }
}
