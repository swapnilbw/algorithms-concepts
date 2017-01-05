package com.example;

import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.apache.http.entity.StringEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class ScoringService {

	@RequestMapping(value="ping" , method=RequestMethod.GET)
	public Response ping(){return Response
			.status(200)
			.entity("Unverify SE service Ping method called successfully.")
			.header("Access-Control-Request-Method", "POST GET DELETE PUT")
			.header("Access-Control-Allow-Origin", "*")
			.header("Access-Control-Allow-Headers",
					"Origin, X-Requested-With, Content-Type, Accept")
			.build();
	}
	@RequestMapping(value="search" , method=RequestMethod.GET)
	public Response searchForScoring(@RequestParam(value="searchStr", defaultValue="") String searchStr,@RequestParam(value="originalStr", defaultValue="") String originalStr) throws Exception{
		// get 100% matching score
		StringEntity strEntity = new StringEntity("{\"query\" : { \"match\" : {\"address\" : \""+originalStr+"\" }}}");
		ServiceResponse response = HttpUtils.httpPostServiceResponse("http://localhost:9200/score/_search",strEntity);
		double completeMatchingScore = response.getScore();
		
		strEntity = new StringEntity("{\"query\" : { \"match\" : {\"address\" : \""+searchStr+"\" }}}");
		String inData = IOUtils.toString(strEntity.getContent(),"UTF-8");
		System.out.println(inData);
		response = HttpUtils.httpPostServiceResponse("http://localhost:9200/score/_search",strEntity);
		double elasticScore = response.getScore();
		double actualScore = (elasticScore/completeMatchingScore)*100;
		response.setActualScore(actualScore);
		return Response
			.status(200)
			.entity(response)
			.header("Access-Control-Request-Method", "POST GET DELETE PUT")
			.header("Access-Control-Allow-Origin", "*")
			.header("Access-Control-Allow-Headers",
					"Origin, X-Requested-With, Content-Type, Accept")
			.build();
	}	
	
	 @OPTIONS
	    @Path("{path : .*}")

	    public Response options() {

	        return Response.ok()
	                .header("Access-Control-Request-Method", "POST GET DELETE PUT")
	                .header("Access-Control-Allow-Credentials", "false")
	                .header("Access-Control-Allow-Origin", "*")
	                .header("Access-Control-Allow-Headers", "Content-Type")
	                .build();

	    }
}
