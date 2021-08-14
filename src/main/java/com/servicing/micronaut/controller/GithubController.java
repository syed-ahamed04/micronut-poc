package com.servicing.micronaut.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

import org.reactivestreams.Publisher;

import com.servicing.micronaut.httpclient.GithubApiClient;
import com.servicing.micronaut.httpclient.GithubLowLevelClient;
import com.servicing.micronaut.httpclient.GithubRelease;

import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.UriMapping;

@Controller("/github") // <1>
public class GithubController {

    private final GithubLowLevelClient githubLowLevelClient;
    private final GithubApiClient githubApiClient;

    public GithubController(GithubLowLevelClient githubLowLevelClient,
                            GithubApiClient githubApiClient) { // <2>
        this.githubLowLevelClient = githubLowLevelClient;
        this.githubApiClient = githubApiClient;
    }

    @Get("/releases-lowlevel") // <3>
    @SingleResult
    Publisher<List<GithubRelease>> releasesWithLowLevelClient() { // <4>
        return githubLowLevelClient.fetchReleases();
    }

    @Get(uri = "/releases", produces = MediaType.APPLICATION_JSON_STREAM) // <5>
    Publisher<GithubRelease> fetchReleases() { // <6>
        return githubApiClient.fetchReleases();
    }
    
    @Get(uri= "/refresh-codeTables", produces = MediaType.APPLICATION_JSON_STREAM) // <3>
     Publisher<String> refreshCodeTables() { // <4>
        return githubLowLevelClient.refreshCodeTables();
    }
    
      
    
	@Post(value = "/queryData", consumes = MediaType.APPLICATION_JSON)
	String queryData(@Body String text) throws IOException, InterruptedException {
		
		
		HttpRequest request = HttpRequest.newBuilder()
		        .uri(URI.create("http://blrcswliqmt0096:10082/loaniqwebservice/restapi/queryData/Deal/None/id/W.EOH25F"))
		        .POST(HttpRequest.BodyPublishers.ofString(text))
		        .build();

		HttpClient client = HttpClient.newHttpClient();
		HttpResponse<String> send = client.send(request, BodyHandlers.ofString());		
		return send.body();
	    }  
	  
		
	@Post(value = "/createloandrawdownData/{rid}", consumes = MediaType.APPLICATION_JSON)
		String createData( @PathVariable("rid") String rid, @Body String text) throws IOException, InterruptedException {		
		HttpRequest request = HttpRequest.newBuilder()
		        .uri(URI.create("http://BLRCSWLIQMT0096:10082/loaniqwebservice/restapi/createData/LoanDrawdown/Facility/id/"+rid))
		        .POST(HttpRequest.BodyPublishers.ofString(text))
		        .build();

		HttpClient client = HttpClient.newHttpClient();
		HttpResponse<String> send = client.send(request, BodyHandlers.ofString());		
		return send.body();
	    }  
    
	
	@Post(value = "/approveloandrawdowndata/{rid}", consumes = MediaType.APPLICATION_JSON)
	String approvalLoanDrawdownData( @PathVariable("rid") String rid , @Body String text) throws IOException, InterruptedException {		
		
	HttpRequest request = HttpRequest.newBuilder()
	        .uri(URI.create("http://BLRCSWLIQMT0096:10082/loaniqwebservice/restapi/actionOnData/ModifyStatus/LoanInitialDrawdown/id/"+rid))
	        .POST(HttpRequest.BodyPublishers.ofString(text))
	        .build();
	
	
	HttpClient client = HttpClient.newHttpClient();
	HttpResponse<String> send = client.send(request, BodyHandlers.ofString());		
	return send.body();
    } 
}
