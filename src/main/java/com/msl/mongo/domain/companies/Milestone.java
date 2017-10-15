
package com.msl.mongo.domain.companies;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Milestone {

    public Integer id;
    public String description;
    public Integer stonedYear;
    public Integer stonedMonth;
    public Integer stonedDay;
    public String sourceUrl;
    public Object sourceText;
    public String sourceDescription;
    public String stoneableType;
    public Object stonedValue;
    public Object stonedValueType;
    public Object stonedAcquirer;
    public Stoneable stoneable;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Milestone() {
    }

    /**
     * 
     * @param stonedYear
     * @param sourceDescription
     * @param sourceText
     * @param stonedValue
     * @param stoneable
     * @param sourceUrl
     * @param id
     * @param stonedDay
     * @param stoneableType
     * @param description
     * @param stonedValueType
     * @param stonedAcquirer
     * @param stonedMonth
     */
    public Milestone(Integer id, String description, Integer stonedYear, Integer stonedMonth, Integer stonedDay, String sourceUrl, Object sourceText, String sourceDescription, String stoneableType, Object stonedValue, Object stonedValueType, Object stonedAcquirer, Stoneable stoneable) {
        super();
        this.id = id;
        this.description = description;
        this.stonedYear = stonedYear;
        this.stonedMonth = stonedMonth;
        this.stonedDay = stonedDay;
        this.sourceUrl = sourceUrl;
        this.sourceText = sourceText;
        this.sourceDescription = sourceDescription;
        this.stoneableType = stoneableType;
        this.stonedValue = stonedValue;
        this.stonedValueType = stonedValueType;
        this.stonedAcquirer = stonedAcquirer;
        this.stoneable = stoneable;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("description", description).append("stonedYear", stonedYear).append("stonedMonth", stonedMonth).append("stonedDay", stonedDay).append("sourceUrl", sourceUrl).append("sourceText", sourceText).append("sourceDescription", sourceDescription).append("stoneableType", stoneableType).append("stonedValue", stonedValue).append("stonedValueType", stonedValueType).append("stonedAcquirer", stonedAcquirer).append("stoneable", stoneable).toString();
    }

}
