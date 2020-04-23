package lg.cn.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommResult(Integer code, String message) {
        this(code, message, null);
    }
}
