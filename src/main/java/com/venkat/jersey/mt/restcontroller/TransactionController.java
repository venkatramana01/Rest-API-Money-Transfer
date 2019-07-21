package com.venkat.jersey.mt.restcontroller;



import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.venkat.jeresy.mt.dto.AccountDTO;
import com.venkat.jeresy.mt.dto.MoneyTransfer;
import com.venkat.jersey.mt.model.Account;
import com.venkat.jersey.mt.service.TransactionService;

import java.util.Collection;
import java.util.List;

@Path("/transactions")
public class TransactionController {

    private final TransactionService transactionService = TransactionService.getInstance();

    @POST
    @Path("transfer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response submitMoneyTransfer(MoneyTransfer trx) {
        List<AccountDTO> result = transactionService.transfer(trx);
		GenericEntity<List<AccountDTO>> entity = new GenericEntity<List<AccountDTO>>(result) {};
        return Response.ok().entity(entity).build();
    }

}
