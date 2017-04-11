package appmanager;

/**
 * Created by korvin on 20.02.2017.
 */
public class ApplicationManager {

  private RestHelper restHelper;



  public RestHelper rest() {
    if (restHelper == null) {
      restHelper = new RestHelper(this);
    }
    return restHelper;
  }
}
