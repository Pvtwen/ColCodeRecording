package dataStructure.Queue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 86153
 * @data 2021/6/12 15:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Element {
    private Object elem;
    private int priority;
}
