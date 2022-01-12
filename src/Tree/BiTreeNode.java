package Tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 86153
 * @data 2021/6/14 16:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BiTreeNode {
    private BiTreeNode leftChild;
    private BiTreeNode rightChild;
    public Object data;
    public boolean isFirst=true;

    public void setData(Object data) {
        this.data = data;
    }
}
