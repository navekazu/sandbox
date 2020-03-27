import javax.swing.UIDefaults;
import javax.swing.plaf.basic.BasicLookAndFeel;

public class MyLookAndFeel extends BasicLookAndFeel {
  public String getDescription() {
    return "This is My Look & Feel.";
  }

  public String getID() {
    return "MyLookAndFeel";
  }

  public String getName() {
    return "My Look & Feel";
  }

  public boolean isNativeLookAndFeel() {
    return false;
  }

  public boolean isSupportedLookAndFeel() {
    return true;
  }

  public UIDefaults getDefaults() {
    UIDefaults uiDefaults = super.getDefaults();
    
    uiDefaults.putDefaults(new Object[] {
      "ButtonUI", "MyButtonUI",
      "TextFieldUI", "MyTextFieldUI",
    });
    
    return uiDefaults;
  }
}