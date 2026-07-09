import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageTest {

    public static void main(String[] args) throws Exception {

        BufferedImage img = ImageIO.read(
            new File(
            "C:\\Users\\koppu\\Desktop\\PhishingWebsiteDetectionSystem\\images\\ai_background.jpg"));

        System.out.println("Width = " + img.getWidth());
        System.out.println("Height = " + img.getHeight());
    }
}
