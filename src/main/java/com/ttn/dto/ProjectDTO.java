package com.ttn.dto;

import java.util.Calendar;
import java.util.List;

public class ProjectDTO {
	
	private String name;
	
	private String countryName;
	
	private String city;
	
	private String companyId;
	
	private String applicationTypeId;
	
	private String engagementTypeId;
	
	private List<Integer> technologiesId;
	
	private String projectDescription;
	
    private Calendar startTime;
	
    private Calendar estimatedEndDate;
	
    private String webAppLink;
	
    private String androidAppLink;
	
    private String appleAppLink;
	
    private boolean isTestimonialPresent;
	
    private boolean isReferenceableInPublicDomain;
	
    private String businessHighlightDocUrl;
	
    private String caseStudyDocUrl;

}
