package MODEL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MODEL_Menu {

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

    public MODEL_Menu(String icon, String name, MenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }

    public MODEL_Menu() {
    }

    private String icon;
    private String name;
    private MenuType type;

    public Icon toIcon() {
        return new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\resources\\icon\\"+ icon+".png");
    }

    public static enum MenuType {
        TITLE, MENU, EMPTY
    }
}
