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
@Path("locacao")
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
    //funcionando
    @GET
    @Produces("application/json")
    public String listLocacao() throws Exception {
        List<LocacaoModel> lista;
        //LocacaoDao dao = new LocacaoDao();
        LocacaoDao dao = LocacaoDao.getInstance();
        List<model.LocacaoModel> locacoes = dao.getAll();
        //Converter para Gson
        Gson g = new Gson();
        return g.toJson(locacoes);
    }
    
    
    @GET
    @Produces("application/json")
    @Path("Locacao/get/{codigolocacao}")
    public String getLocacao(@PathParam("codigolocacao") int codigolocacao) throws Exception {
        LocacaoModel l = new LocacaoModel();
        l.setCodigolocacao(codigolocacao);

        //LocacaoDao dao = new LocacaoDao();
        LocacaoDao dao = LocacaoDao.getInstance();
        l = dao.buscar(l);

        //Converter para Gson
        Gson g = new Gson();
        return g.toJson(l);
    }
    
    
    @POST
    @Consumes({"application/json"})
    @Path("LocacaoCadastrarEmprestimo/inserir")
    public boolean inserir(String content) throws Exception {
        Gson g = new Gson();
        LocacaoModel l = (LocacaoModel) g.fromJson(content, LocacaoModel.class);
        //LocacaoDao dao = new LocacaoDao();
        LocacaoDao dao = LocacaoDao.getInstance();
        return dao.inserirLocacao(l);
    }
    
    
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
    
    //criar um point para ver se o carro esta disponivel 
    //colocar nesse point o codigo do carro, o status (pesquisar pelo codigoCarro)
    @GET
    @Produces("application/json")
    @Path("DisponibilidadeCarro/get/{codigocarro}")
    public String getDisponivel(@PathParam("codigocarro") int codigocarro) throws Exception {
        LocacaoModel c = new LocacaoModel();
        c.setCodigocarro(codigocarro);

        //LocacaoDao dao = new LocacaoDao();
        LocacaoDao dao = LocacaoDao.getInstance();
        c = dao.buscarDisponibilidade(c);

        //Converter para Gson
        Gson g = new Gson();
        return g.toJson(c);
    }
    
    
    
}
