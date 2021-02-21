/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import dao.CarroDao;
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
import model.CarroModel;

/**
 * REST Web Service
 *
 * @author Robson
 */
@Path("carro")
public class CarroResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CarroResource
     */
    public CarroResource() {
    }

    /**
     * Retrieves representation of an instance of api.CarroResource
     * @return an instance of java.lang.String
     */
    
    //funcionando get todos os carros
    @GET
    @Produces("application/json")
    public String listCarro() throws Exception {
        List<CarroModel> lista;
        //CarroDao dao = new CarroDao();
        CarroDao dao = CarroDao.getInstance();
        List<model.CarroModel> carros = dao.getAll();
        //Converter para Gson
        Gson g = new Gson();
        return g.toJson(carros);
    }

    //funcionando get pela placa do carro
    @GET
    @Produces("application/json")
    @Path("Carro/get/{placa}")
    public String getCarro(@PathParam("placa") String placa) throws Exception {
        CarroModel c = new CarroModel();
        c.setPlaca(placa);

        //CarroDao dao = new CarroDao();
        CarroDao dao = CarroDao.getInstance();
        c = dao.buscar(c);

        //Converter para Gson
        Gson g = new Gson();
        return g.toJson(c);
    }
    
    //funcionando inserir
    @POST
    @Consumes({"application/json"})
    @Path("Carro/inserir")
    public boolean inserir(String content) throws Exception {
        Gson g = new Gson();
        CarroModel c = (CarroModel) g.fromJson(content, CarroModel.class);
        //CarroDao dao = new CarroDao();
        CarroDao dao = CarroDao.getInstance();
        return dao.inserirCarro(c);
    }
    
    //funcionando alteração pelo codigo do carro
    @PUT
    @Consumes("application/json")
    @Path("Carro/alterar")
    public boolean alterar(String content) throws Exception {
        Gson g = new Gson();
        CarroModel c = (CarroModel) g.fromJson(content, CarroModel.class);
        //CarroDao dao = new CarroDao();
        CarroDao dao = CarroDao.getInstance();
        return dao.atualizar(c);
    }
    
    
    //funcionando 
    @GET
    @Path("Carro/excluir/{placa}")
    public String excluir(@PathParam("placa") String placa) throws Exception {
        CarroModel c = new CarroModel();
        //CarroDao dao = new CarroDao();
        CarroDao dao = CarroDao.getInstance();
        c.setPlaca(placa);

        if (dao.excluir(placa)) {
            return "true";
        } else {
            return "false";
        }

    }
}
