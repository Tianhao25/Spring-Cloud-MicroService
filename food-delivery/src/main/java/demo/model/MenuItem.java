package demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuItem {
    private String category;
    private String foodName;

    //@JsonIgnoreProperties
    private String foodPicture;

    private String ingredients;
    private Grains grains = Grains.NO_Grains;

    private String extras;
    private Integer quantity;
    private String dietRestrictions;
    private String dressingOption;
    private Double price;
}