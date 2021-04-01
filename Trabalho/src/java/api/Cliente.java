/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import dao.ClienteDao;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.jms.JMSException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import model.ClienteModel;
import org.jboss.logging.Param;

/**
 * REST Web Service
 *
 * @author Robson
 */
@Path("Cliente")
public class Cliente {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Aluno
     */
    public Cliente() {
    }

    /**
     * Retrieves representation of an instance of api.ClienteModel
     *
     * @return an instance of java.lang.String
     */
    //funcionando que retorna todos na lista
    @GET
    @Produces("application/json")
    public String listUsuarios() throws Exception {
        List<ClienteModel> lista;
        //ClienteDao dao = new ClienteDao();
        ClienteDao dao = ClienteDao.getInstance();
        List<model.ClienteModel> clientes = dao.getAll();
        //Converter para Gson
        Gson g = new Gson();
        return g.toJson(clientes);
    }

    //funcionando o get pelo cpf
    @GET
    @Produces("application/json")
    @Path("Cliente/get/{cpf}")
    public String getCliente(@PathParam("cpf") String cpf) throws Exception {
        ClienteModel c = new ClienteModel();
        c.setCpf(cpf);
        
        //ClienteDao dao = new ClienteDao();
        ClienteDao dao = ClienteDao.getInstance();
        c = dao.buscar(c);

        //Converter para Gson
        Gson g = new Gson();
        return g.toJson(c);
    }

    //funcionando
    @POST
    @Consumes({"application/json"})
    @Path("Cliente/inserir")
    public boolean inserir(String content) throws Exception {
        Gson g = new Gson();
        ClienteModel c = (ClienteModel) g.fromJson(content, ClienteModel.class);
        //ClienteDao dao = new ClienteDao();
        ClienteDao dao = ClienteDao.getInstance();
        return dao.inserirCliente(c);
    }

    //funcionando 
    @PUT
    @Consumes("application/json")
    @Path("Cliente/alterar")
    public boolean alterar(String content) throws Exception {
        Gson g = new Gson();
        ClienteModel c = (ClienteModel) g.fromJson(content, ClienteModel.class);
        //ClienteDao dao = new ClienteDao();
        ClienteDao dao = ClienteDao.getInstance();
        return dao.atualizar(c);
    }

    //funcionando 
    @GET
    @Path("Cliente/excluir/{cpf}")
    public String excluir(@PathParam("cpf") String cpf) throws Exception {
        ClienteModel c = new ClienteModel();
        //ClienteDao dao = new ClienteDao();
        ClienteDao dao = ClienteDao.getInstance();
        c.setCpf(cpf);

        if (dao.excluir(cpf)) {
            return "true";
        } else {
            return "false";
        }

    }
}
