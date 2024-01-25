package models;
import lombok.*;

import java.util.ArrayList;
@Data
@AllArgsConstructor
public class UserListRootResponse {

    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;
    private ArrayList<UserResponse> data;
    private Support support;

}
