package easy;

import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class Images {
    BufferedImage robot;
    BufferedImage wall;
    BufferedImage ground;
    BufferedImage goal;

    public Images()throws IOException {
        robot = ImageIO.read(new File("images/Robot.png"));
        wall = ImageIO.read(new File("images/Wall.png"));
        ground = ImageIO.read(new File("images/Ground.png"));
        goal = ImageIO.read(new File("images/Goal.png"));
    }
}
