package tzhmufl2.android_hellospring.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

/**
 * Created by tzhmufl2 on 15.06.14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DTOCharacterResponseList extends ArrayList<Character>
{
}