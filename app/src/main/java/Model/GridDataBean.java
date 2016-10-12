package Model;

/**
 * Created by clark on 2016/10/12.
 */

public class GridDataBean {
    public String name;
    public int iconid;

    public GridDataBean(String name, int iconid) {
        this.name = name;
        this.iconid = iconid;
    };

    public int getIconid() {
        return iconid;
    }

    public void setIconid(int iconid) {
        this.iconid = iconid;
    }
}
