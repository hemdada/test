/*Generated by WaveMaker Studio*/
package com.test.highscoredb.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Qualifier;
import com.test.highscoredb.service.HighscoredbQueryExecutorService;
import com.wavemaker.runtime.data.model.CustomQuery;
import com.wavemaker.runtime.data.exception.QueryParameterMismatchException;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@RestController(value = "Highscoredb.QueryExecutionController")
@RequestMapping("/highscoredb/queryExecutor")
@Api(value = "QueryExecutionController", description = "Controller class for query execution")
public class QueryExecutionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryExecutionController.class);

    @Autowired
    private HighscoredbQueryExecutorService queryService;

    @RequestMapping(value = "/queries/wm_custom", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Process request to execute customer queries")
    public Page<Object> executeWMCustomQuery(@RequestBody @ApiParam(value = "") CustomQuery query, @ApiParam(value = "") Pageable pageable) {
        Page<Object> result = queryService.executeWMCustomQuerySelect(query, pageable);
        LOGGER.debug("got the result {}" + result);
        return result;
    }

    @RequestMapping(value = "/queries/wm_custom_update", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Process request to execute customer queries")
    public int executeWMCustomQuery(@RequestBody @ApiParam(value = "") CustomQuery query) {
        int result = queryService.executeWMCustomQueryUpdate(query);
        LOGGER.debug("got the result {}" + result);
        return result;
    }
}