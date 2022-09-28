import java.util.*;

public class BannerTestHarness
{
    public static void main(String[] args)
    {
	boolean valid = false;  	
	BannerClass bannerObj1 = new BannerClass();
	BannerClass bannerObj2 = new BannerClass();
	if(bannerObj1.equals(bannerObj2))
	{
		valid = true;
	}
	System.out.println(valid);
    }
}
