
package com.msl.mongo.domain.companies;

import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Company {

    public String id;
    public String name;
    public String permalink;
    public String crunchbaseUrl;
    public String homepageUrl;
    public String blogUrl;
    public String blogFeedUrl;
    public String twitterUsername;
    public String categoryCode;
    public Integer numberOfEmployees;
    public Integer foundedYear;
    public Integer foundedMonth;
    public Integer foundedDay;
    public Object deadpooledYear;
    public Object deadpooledMonth;
    public Object deadpooledDay;
    public Object deadpooledUrl;
    public String tagList;
    public String aliasList;
    public String emailAddress;
    public String phoneNumber;
    public String description;
    public String createdAt;
    public String updatedAt;
    public String overview;
    public Image image;
    public List<Product> products = null;
    public List<Relationship> relationships = null;
    public List<Competition> competitions = null;
    public List<Object> providerships = null;
    public String totalMoneyRaised;
    public List<FundingRound> fundingRounds = null;
    public List<Object> investments = null;
    public Acquisition acquisition;
    public List<Object> acquisitions = null;
    public List<Office> offices = null;
    public List<Milestone> milestones = null;
    public Object ipo;
    public List<VideoEmbed> videoEmbeds = null;
    public List<Object> screenshots = null;
    public List<Object> externalLinks = null;
    public List<Object> partners = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Company() {
    }

    /**
     * 
     * @param ipo
     * @param foundedMonth
     * @param foundedYear
     * @param providerships
     * @param blogUrl
     * @param id
     * @param acquisition
     * @param competitions
     * @param phoneNumber
     * @param partners
     * @param videoEmbeds
     * @param offices
     * @param screenshots
     * @param description
     * @param createdAt
     * @param name
     * @param numberOfEmployees
     * @param fundingRounds
     * @param twitterUsername
     * @param relationships
     * @param products
     * @param investments
     * @param externalLinks
     * @param categoryCode
     * @param image
     * @param aliasList
     * @param emailAddress
     * @param blogFeedUrl
     * @param foundedDay
     * @param homepageUrl
     * @param deadpooledUrl
     * @param updatedAt
     * @param milestones
     * @param overview
     * @param permalink
     * @param deadpooledMonth
     * @param deadpooledYear
     * @param deadpooledDay
     * @param crunchbaseUrl
     * @param totalMoneyRaised
     * @param tagList
     * @param acquisitions
     */
    public Company(String id, String name, String permalink, String crunchbaseUrl, String homepageUrl, String blogUrl, String blogFeedUrl, String twitterUsername, String categoryCode, Integer numberOfEmployees, Integer foundedYear, Integer foundedMonth, Integer foundedDay, Object deadpooledYear, Object deadpooledMonth, Object deadpooledDay, Object deadpooledUrl, String tagList, String aliasList, String emailAddress, String phoneNumber, String description, String createdAt, String updatedAt, String overview, Image image, List<Product> products, List<Relationship> relationships, List<Competition> competitions, List<Object> providerships, String totalMoneyRaised, List<FundingRound> fundingRounds, List<Object> investments, Acquisition acquisition, List<Object> acquisitions, List<Office> offices, List<Milestone> milestones, Object ipo, List<VideoEmbed> videoEmbeds, List<Object> screenshots, List<Object> externalLinks, List<Object> partners) {
        super();
        this.id = id;
        this.name = name;
        this.permalink = permalink;
        this.crunchbaseUrl = crunchbaseUrl;
        this.homepageUrl = homepageUrl;
        this.blogUrl = blogUrl;
        this.blogFeedUrl = blogFeedUrl;
        this.twitterUsername = twitterUsername;
        this.categoryCode = categoryCode;
        this.numberOfEmployees = numberOfEmployees;
        this.foundedYear = foundedYear;
        this.foundedMonth = foundedMonth;
        this.foundedDay = foundedDay;
        this.deadpooledYear = deadpooledYear;
        this.deadpooledMonth = deadpooledMonth;
        this.deadpooledDay = deadpooledDay;
        this.deadpooledUrl = deadpooledUrl;
        this.tagList = tagList;
        this.aliasList = aliasList;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.overview = overview;
        this.image = image;
        this.products = products;
        this.relationships = relationships;
        this.competitions = competitions;
        this.providerships = providerships;
        this.totalMoneyRaised = totalMoneyRaised;
        this.fundingRounds = fundingRounds;
        this.investments = investments;
        this.acquisition = acquisition;
        this.acquisitions = acquisitions;
        this.offices = offices;
        this.milestones = milestones;
        this.ipo = ipo;
        this.videoEmbeds = videoEmbeds;
        this.screenshots = screenshots;
        this.externalLinks = externalLinks;
        this.partners = partners;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("permalink", permalink).append("crunchbaseUrl", crunchbaseUrl).append("homepageUrl", homepageUrl).append("blogUrl", blogUrl).append("blogFeedUrl", blogFeedUrl).append("twitterUsername", twitterUsername).append("categoryCode", categoryCode).append("numberOfEmployees", numberOfEmployees).append("foundedYear", foundedYear).append("foundedMonth", foundedMonth).append("foundedDay", foundedDay).append("deadpooledYear", deadpooledYear).append("deadpooledMonth", deadpooledMonth).append("deadpooledDay", deadpooledDay).append("deadpooledUrl", deadpooledUrl).append("tagList", tagList).append("aliasList", aliasList).append("emailAddress", emailAddress).append("phoneNumber", phoneNumber).append("description", description).append("createdAt", createdAt).append("updatedAt", updatedAt).append("overview", overview).append("image", image).append("products", products).append("relationships", relationships).append("competitions", competitions).append("providerships", providerships).append("totalMoneyRaised", totalMoneyRaised).append("fundingRounds", fundingRounds).append("investments", investments).append("acquisition", acquisition).append("acquisitions", acquisitions).append("offices", offices).append("milestones", milestones).append("ipo", ipo).append("videoEmbeds", videoEmbeds).append("screenshots", screenshots).append("externalLinks", externalLinks).append("partners", partners).toString();
    }

}
