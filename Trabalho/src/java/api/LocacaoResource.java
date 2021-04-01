/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import dao.LocacaoDao;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.LocacaoModel;

/**
 * REST Web Service
 *
 * @author Robson
 */
@Path("Locacao")
public class LocacaoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LocacaoResource
     */
    public LocacaoResource() {
    }

    /**
     * Retrieves representation of an instance of api.LocacaoResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String listUsuarios() throws Exception {
        List<LocacaoModel> lista;
        //LocacaoDao dao = new LocacaoDao();
        LocacaoDao dao = LocacaoDao.getInstance();
        List<model.LocacaoModel> locacoes = dao.getAll();
        //Converter para Gson
        Gson g = new Gson();
        return g.toJson(locacoes);
    }
    
    
    //get carro
    @GET
    @Produces("application/json")
    @Path("LocacaoCarro/get/{codigocarro}")
    public String getCarro(@PathParam("codigocarro") String carro) throws Exception {
        LocacaoModel c = new LocacaoModel();
        c.setCodigocarro(carro);

        //LocacaoDao dao = new LocacaoDao();
        LocacaoDao dao = LocacaoDao.getInstance();
        c = dao.buscarCarro(c);

        //Converter para Gson
        Gson g = new Gson();
        return g.toJson(c);
    }
    
    //get cliente
    @GET
    @Produces("application/json")
    @Path("LocacaoCliente/get/{codigocliente}")
    public String getCliente(@PathParam("codigocliente") String codigocliente) throws Exception {
        LocacaoModel c = new LocacaoModel();
        c.setCodigocliente(codigocliente);

        //LocacaoDao dao = new LocacaoDao();
        LocacaoDao dao = LocacaoDao.getInstance();
        c = dao.buscarCliente(c);

        //Converter para Gson
        Gson g = new Gson();
        return g.toJson(c);
    }
    
    
    //get data
    @GET
    @Produces("application/json")
    @Path("LocacaoData/get/{data_locacao}")
    public String getData(@PathParam("data_locacao") String data) throws Exception {
        LocacaoModel c = new LocacaoModel();
        c.setData_locacao(data);

        //LocacaoDao dao = new LocacaoDao();
        LocacaoDao dao = LocacaoDao.getInstance();
        c = dao.buscarData(c);

        //Converter para Gson
        Gson g = new Gson();
        return g.toJson(c);
    }
    
    
    
    //http://localhost:8080/Trabalho/webresources/Locacao/Locacao/inserir
    @POST
    @Consumes({"application/json"})
    @Path("Locacao/inserir")
    public boolean inserir(String content) throws Exception {
        Gson g = new Gson();
        LocacaoModel c = (LocacaoModel) g.fromJson(content, LocacaoModel.class);
        //LocacaoDao dao = new LocacaoDao();
        LocacaoDao dao = LocacaoDao.getInstance();
        return dao.inserirLocacao(c);
    }

    /**
     * PUT method for updating or creating an instance of LocacaoResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes("application/json")
    @Path("LocacaoDevolucao/alterar")
    public boolean alterar(String content) throws Exception {
        Gson g = new Gson();
        LocacaoModel l = (LocacaoModel) g.fromJson(content, LocacaoModel.class);
        //LocacaoDao dao = new LocacaoDao();
        LocacaoDao dao = LocacaoDao.getInstance();
        return dao.atualizar(l);
    }
}
