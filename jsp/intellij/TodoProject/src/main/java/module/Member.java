package module;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Member {
    private String uuid;
    private String id;
    private String pw;
    private long idx;
}
