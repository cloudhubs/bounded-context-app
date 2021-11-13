package edu.baylor.ecs.prophet.boundedcontextapp;

import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.baylor.ecs.cloudhubs.prophetdto.app.boundedcontext.BoundedContextRequest;
import edu.baylor.ecs.cloudhubs.prophetdto.systemcontext.BoundedContext;
import edu.baylor.ecs.prophet.bounded.context.api.BoundedContextApi;
import edu.baylor.ecs.prophet.bounded.context.api.impl.BoundedContextApiImpl;

/**
 * Simple wrapper exposing the bounded-context library to non-Java programs.
 * 
 * @author Micah
 */
@RestController
public class BoundedContextAppController {

	/** API we're exposing */
	private final BoundedContextApi api = new BoundedContextApiImpl();

	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public BoundedContext getRadSourceResponseContext(@RequestBody BoundedContextRequest request) throws IOException {
		return api.getBoundedContext(request.getContext(), request.useWuPalmer());
	}
}
