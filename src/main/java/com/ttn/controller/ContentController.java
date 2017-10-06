package com.ttn.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Mm content controller.
 */
@RestController
@RequestMapping("/api/")
public class ContentController {

//	@RequestMapping(value = "/editorial/section", method = RequestMethod.POST, consumes = "application/json")
//    public ResponseDto createEditorialSection(@RequestBody @Valid EditorialSectionDto sectionDto,
//                                              @RequestHeader(value = "locale", defaultValue = "en") String locale) {
//        LOGGER.info("Request :: create editorial section with request body : " + sectionDto);
//        EditorialSectionDto editorialSectionDto = editorialSectionService.createEditorialSection(sectionDto);
//        ResponseDto responseDto = responseUtil.prepareSuccessResponse(editorialSectionDto, EDITORIAL_SECTION_CREATE, locale);
//        LOGGER.info("Response :: create editorial section with request body : " + sectionDto + " is => " + responseDto);
//        return responseDto;
//    }

}
