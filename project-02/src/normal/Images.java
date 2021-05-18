package normal;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Images {
    BufferedImage robotD;
    BufferedImage robotU;
    BufferedImage robotL;
    BufferedImage robotR;
    BufferedImage wall;
    BufferedImage ground;
    BufferedImage goal;
    BufferedImage bBox;
    BufferedImage rBox;

    public Images()throws IOException {
        robotD = ImageIO.read(new File("images/RobotD.png"));
        robotU = ImageIO.read(new File("images/RobotU.png"));
        robotL = ImageIO.read(new File("images/RobotL.png"));
        robotR = ImageIO.read(new File("images/RobotR.png"));
        wall = ImageIO.read(new File("images/Wall.png"));
        ground = ImageIO.read(new File("images/Ground.png"));
        goal = ImageIO.read(new File("images/Goal.png"));
        bBox =  ImageIO.read(new File("images/BoxBlue.png"));
        rBox =  ImageIO.read(new File("images/BoxRed.png"));
    }
}
