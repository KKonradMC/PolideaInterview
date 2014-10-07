package org.kkonrad.polideainterview.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@Accessors(prefix = "m")
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode
public class MigrationInfo {
    public static final String ON_DATE = "on_date";
    public static final String QUESTION_ID = "question_id";

    @Getter
    @Setter
    @JsonProperty(ON_DATE)
    private Date mOnDate;

    @Getter
    @Setter
    @JsonProperty(QUESTION_ID)
    private Integer mQuestionId;
}
