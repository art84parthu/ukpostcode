package com.wcc.interview.posta.code.distance.service;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import com.wcc.interview.postal.code.distance.service.PostalCodeDistanceService;
public class PostalCodeDistanceServiceTest extends JerseyTest{

	@Override
	protected Application configure() {
		return new ResourceConfig(PostalCodeDistanceService.class);
	}

	@Test
	public void test() {
		final String response = target("PostalCodeDistance/YO51/YO61").request().get(String.class);
		}
}
