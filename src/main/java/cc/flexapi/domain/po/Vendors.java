package cc.flexapi.domain.po;


import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.Data;

@Data
@ApiResponse(description = "Vendors")
public class Vendors {

    private Integer id;

    private String name;

    private String description;

    private String icon;

    int status;

    int deleted_at;

    int created_time;

    int updated_time;

}
