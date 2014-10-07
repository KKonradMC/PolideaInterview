package org.kkonrad.polideainterview.rest;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.RestClientErrorHandling;
import org.kkonrad.polideainterview.model.QuestionList;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;


@Rest(rootUrl = "https://api.stackexchange.com/2.2/search", converters = MappingJackson2HttpMessageConverter.class)
public interface SearchRestClient extends RestClientErrorHandling {
    @Get("/?order=desc&sort=activity&intitle={inTitle}&site=stackoverflow")
    QuestionList getPostsByTitle(String inTitle);
}
