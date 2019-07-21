package com.venkat.jersey.mt.restcontroller;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.venkat.jersey.mt.model.Account;
import com.venkat.jersey.mt.repository.AccountRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Path("/accounts")
public class AccountController {

	private final AccountRepository repository = AccountRepository.getInstance();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Welcome to Money transfer!!!";
	}

	@GET
	@Path("allaccounts")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAccounts() {
		System.out.println("all accounts-->");
		GenericEntity<Collection<Account>> entity = new GenericEntity<Collection<Account>>(repository.getAll()) {
		};
		return Response.ok(entity).build();
	}

	@GET
	@Path("account/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAccountById(@PathParam("id") String id) {
		System.out.println("In finding account  by Id :" + id);
		Account account = repository.getById(id);
		if (account == null)
			return Response.noContent().build();

		return Response.ok(account).build();
	}

	@POST
	@Path("account")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createNewAccount(Account account) {
		System.out.println("creating account" + account);
		repository.addAccount(account);
		return Response.ok(account).build();
	}
}
