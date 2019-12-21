package methods_core.resource;

public class ResourceHelper
{
    public static String getRecoursePath(String path)
    {
        String basePath = System.getProperty("user.dir");
        return basePath + path;
    }
}
